package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.employeeRequestDTO.EmployeeRequestDTO;
import com.FuelBackend.service.employeeService.EmployeeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeServiceRepository employeeServiceRepository;

    @Autowired
    public EmployeeController(EmployeeServiceRepository employeeServiceRepository) {
        this.employeeServiceRepository = employeeServiceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeServiceRepository.createEmployee(employeeRequestDTO);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable int employeeId,@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeServiceRepository.updateEmployee(employeeId,employeeRequestDTO);
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<?> changeEmployeeStatus(@PathVariable int employeeId){
        return employeeServiceRepository.changeEmployeeStatus(employeeId);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> employeeFindById(@PathVariable int employeeId){
        return employeeServiceRepository.employeeFindById(employeeId);
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees(){
        return employeeServiceRepository.getAllEmployee();
    }

    @PutMapping("/fuel/{employeeId}")
    public ResponseEntity<?> updateFuelPerVehicle(
            @PathVariable int employeeId,
            @RequestBody int vehicleId,Double fuelCapacity
    ){

        return employeeServiceRepository.updateFuelPerVehicle(employeeId,vehicleId,fuelCapacity);
    }
}
