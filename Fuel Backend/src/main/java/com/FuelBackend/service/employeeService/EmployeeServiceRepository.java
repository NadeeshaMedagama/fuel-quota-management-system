package com.FuelBackend.service.employeeService;

import com.FuelBackend.dataTransferObject.request.employeeRequestDTO.EmployeeRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface EmployeeServiceRepository {

    public ResponseEntity<?> createEmployee(EmployeeRequestDTO employeeRequestDTO);

    public ResponseEntity<?> updateEmployee(int employeeId, EmployeeRequestDTO employeeRequestDTO);

    public ResponseEntity<?> updateFuelPerVehicle(int employeeId,int vehicleId,Double fuelCapacity);

    public ResponseEntity<?> changeEmployeeStatus(int employeeId);
}
