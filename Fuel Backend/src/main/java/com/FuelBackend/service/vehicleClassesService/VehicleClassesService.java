package com.FuelBackend.service.vehicleClassesService;

import com.FuelBackend.dataTransferObject.request.vehicleClassesRequestDTO.VehicleClassesRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.vehicleClassesResponseDTO.VehicleClassesResponseDTO;
import com.FuelBackend.entity.Fuel;
import com.FuelBackend.entity.VehicleClasses;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.FuelRepository;
import com.FuelBackend.repositoryDAO.VehicleClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleClassesService implements VehicleClassesServiceRepository{

    private final VehicleClassesRepository vehicleClassesRepository;

    private final FuelRepository fuelRepository;

    @Autowired
    public VehicleClassesService(VehicleClassesRepository vehicleClassesRepository, FuelRepository fuelRepository) {
        this.vehicleClassesRepository = vehicleClassesRepository;
        this.fuelRepository = fuelRepository;
    }


    @Override
    public ResponseEntity<?> createVehicleClass(VehicleClassesRequestDTO vehicleClassesRequestDTO) {

        VehicleClasses vehicleClass = new VehicleClasses(
                vehicleClassesRequestDTO.getVehicleClassName(),
                vehicleClassesRequestDTO.getMaxFuelCapacityPerWeek(),
                vehicleClassesRequestDTO.getMaxFuelCapacityPerWeekForBusinessGov()
        );

        VehicleClasses savedVehicleClass = vehicleClassesRepository.save(vehicleClass);

        VehicleClassesResponseDTO responseDTO = new VehicleClassesResponseDTO(
                savedVehicleClass.getVehicleClassId(),
                savedVehicleClass.getVehicleClassName(),
                savedVehicleClass.getMaxFuelCapacityPerWeek(),
                savedVehicleClass.getMaxFuelCapacityPerWeekForBusinessGov()
        );

        return new ResponseEntity<>(

                        responseDTO,

                HttpStatus.CREATED

        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateVehicleClassMaxFuelCapacityPerWeek(Integer vehicleClassId, Double maxFuelCapacityPerWeek) {
        VehicleClasses vehicleClass = vehicleClassesRepository.findById(vehicleClassId).orElseThrow(
                () -> new NotFoundException("vehicle class not found")
        );
        vehicleClass.setMaxFuelCapacityPerWeek(maxFuelCapacityPerWeek);


        vehicleClassesRepository.save(vehicleClass);

        VehicleClassesResponseDTO responseDTO = new VehicleClassesResponseDTO(
                vehicleClass.getVehicleClassId(),
                vehicleClass.getVehicleClassName(),
                vehicleClass.getMaxFuelCapacityPerWeek(),
                vehicleClass.getMaxFuelCapacityPerWeekForBusinessGov()
        );

        return new ResponseEntity<>(

                        responseDTO
                ,
                HttpStatus.OK
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateVehicleClassMaxFuelCapacityPerWeekForBusinessGov(
            Integer vehicleClassId,
            Double maxFuelCapacityPerWeekForBusinessGov
    ) {
        VehicleClasses vehicleClass = vehicleClassesRepository.findById(vehicleClassId).orElseThrow(
                () -> new NotFoundException("vehicle id not found")
        );

        vehicleClass.setMaxFuelCapacityPerWeekForBusinessGov(maxFuelCapacityPerWeekForBusinessGov);
        vehicleClassesRepository.save(vehicleClass);

        VehicleClassesResponseDTO responseDTO = new VehicleClassesResponseDTO(
                vehicleClass.getVehicleClassId(),
                vehicleClass.getVehicleClassName(),
                vehicleClass.getMaxFuelCapacityPerWeek(),
                vehicleClass.getMaxFuelCapacityPerWeekForBusinessGov()
        );

        return new ResponseEntity<>(

                        responseDTO
                ,
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> vehicleClassFindById(Integer vehicleClassId) {
        VehicleClasses vehicleClass = vehicleClassesRepository.findById(vehicleClassId).orElseThrow(
                () -> new NotFoundException("vehicle class not found")
        );

        vehicleClassesRepository.save(vehicleClass);
        VehicleClassesResponseDTO responseDTO = new VehicleClassesResponseDTO(
                vehicleClass.getVehicleClassId(),
                vehicleClass.getVehicleClassName(),
                vehicleClass.getMaxFuelCapacityPerWeek(),
                vehicleClass.getMaxFuelCapacityPerWeekForBusinessGov()

        );

        return new ResponseEntity<>(

                        responseDTO
                ,
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getAllVehicleClasses() {
        List<VehicleClasses> allVehicleClasses = vehicleClassesRepository.findAll();
        List<VehicleClassesResponseDTO> responseDTO = new ArrayList<>();

        allVehicleClasses.forEach(
                vehicleClass -> {
                    responseDTO.add(
                            new VehicleClassesResponseDTO(
                                    vehicleClass.getVehicleClassId(),
                                    vehicleClass.getVehicleClassName(),
                                    vehicleClass.getMaxFuelCapacityPerWeek(),
                                    vehicleClass.getMaxFuelCapacityPerWeekForBusinessGov()
                            )
                    );
                }
        );
        return new ResponseEntity<>(

                        responseDTO,

                HttpStatus.OK
        );
    }
}
