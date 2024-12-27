package com.FuelBackend.service.employeeService;

import com.FuelBackend.dataTransferObject.request.employeeRequestDTO.EmployeeRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmployeeServiceRepository {

    public ResponseEntity<?> createEmployee(EmployeeRequestDTO employeeRequestDTO);

    public ResponseEntity<?> updateEmployee(UUID employeeId, EmployeeRequestDTO employeeRequestDTO);

    public ResponseEntity<?> updateFuelPerVehicle(UUID employeeId,UUID vehicleId,Double fuelCapacity);

    public ResponseEntity<?> changeEmployeeStatus(UUID employeeId);
}
