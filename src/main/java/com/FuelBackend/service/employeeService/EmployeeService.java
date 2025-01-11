package com.FuelBackend.service.employeeService;

import com.FuelBackend.calculation.FuelCalculation;
import com.FuelBackend.dataTransferObject.request.employeeRequestDTO.EmployeeRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.employeeResponseDTO.EmployeeResponseDTO;
import com.FuelBackend.entity.Employee;
import com.FuelBackend.entity.FuelStation;
import com.FuelBackend.entity.Vehicle;
import com.FuelBackend.enums.OwnerType;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.EmployeeRepository;
import com.FuelBackend.repositoryDAO.FuelStationRepository;
import com.FuelBackend.repositoryDAO.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService implements EmployeeServiceRepository{

    private final EmployeeRepository employeeRepository;

    private final VehicleRepository vehicleRepository;

    private final FuelStationRepository fuelStationRepository;


    public EmployeeService(EmployeeRepository employeeRepository, VehicleRepository vehicleRepository, FuelStationRepository fuelStationRepository) {
        this.employeeRepository = employeeRepository;
        this.vehicleRepository = vehicleRepository;
        this.fuelStationRepository = fuelStationRepository;
    }

    @Override
    public ResponseEntity<?> createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        FuelStation fuelStation = fuelStationRepository.findById(employeeRequestDTO.getFuelStationId()).orElseThrow(
                () -> new NotFoundException("fuel Station not found")
        );
        Employee employee = new Employee(
                employeeRequestDTO.getEmployeeUsername(),
                employeeRequestDTO.getPassword(),
                employeeRequestDTO.getEmployeeEmail(),
                fuelStation,
                true
        );

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO(
                savedEmployee.getEmployeeId(),
                savedEmployee.getEmployeeUsername(),
                savedEmployee.getEmployeeEmail(),
                savedEmployee.getFuelStation().getFuelStationId(),
                savedEmployee.getEmployeeStatus()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.CREATED.value(),
                        "employee created successfully",
                        responseDTO
                ),
                HttpStatus.CREATED
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateEmployee(UUID employeeId, EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("employee not found")
        );
        employee.setEmployeeUsername(employeeRequestDTO.getEmployeeUsername());
        employee.setEmployeeEmail(employeeRequestDTO.getEmployeeEmail());
        employee.setPassword(employeeRequestDTO.getPassword());
        employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getEmployeeUsername(),
                employee.getEmployeeEmail(),
                employee.getFuelStation().getFuelStationId(),
                employee.getEmployeeStatus()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "employee updated successfully",
                        responseDTO
                ),
                HttpStatus.OK
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> changeEmployeeStatus(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("employee not found")
        );
        employee.setEmployeeStatus(!employee.getEmployeeStatus());

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getEmployeeUsername(),
                employee.getEmployeeEmail(),
                employee.getFuelStation().getFuelStationId(),
                employee.getEmployeeStatus()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "change employee status successfully",
                        responseDTO
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> employeeFindById(UUID employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new NotFoundException("employee id not found")
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        null,
                        new EmployeeResponseDTO(
                                employee.getEmployeeId(),
                                employee.getEmployeeUsername(),
                                employee.getEmployeeEmail(),
                                employee.getFuelStation().getFuelStationId(),
                                employee.getEmployeeStatus()
                        )
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponseDTO> employeeResponseDTOList = new ArrayList<>();

        employeeList.forEach(
                employee -> {
                    employeeResponseDTOList.add(
                            new EmployeeResponseDTO(
                                    employee.getEmployeeId(),
                                    employee.getEmployeeUsername(),
                                    employee.getEmployeeEmail(),
                                    employee.getFuelStation().getFuelStationId(),
                                    employee.getEmployeeStatus()
                            )
                    );
                }
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        null,
                        employeeResponseDTOList
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> updateFuelPerVehicle(UUID employeeId, UUID vehicleId, Double fuelCapacity) {
        // extract the vehicle details
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new NotFoundException("vehicle id not found")
        );

        Double maxFuelCapacityPerWeek;
        // check the vehicle owner type and get max capacity
        if(vehicle.getOwnerType() == OwnerType.User){
            maxFuelCapacityPerWeek = vehicle.getVehicleClasses().getMaxFuelCapacityPerWeek();
        }else{
            maxFuelCapacityPerWeek = vehicle.getVehicleClasses().getMaxFuelCapacityPerWeekForBusinessGov();
        }

        Double currentFuelCapacity = vehicle.getCurrentFuelCapacity();

        Double fuelCap = FuelCalculation.calculateFuel(
                maxFuelCapacityPerWeek,
                currentFuelCapacity,
                fuelCapacity
        );
        // update currentFuelCapacity
        vehicle.setCurrentFuelCapacity(fuelCap);
        vehicleRepository.save(vehicle);

        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "vehicle fuel capacity updated sucessfully",
                        null

                ),
                HttpStatus.OK
        );
    }
}
