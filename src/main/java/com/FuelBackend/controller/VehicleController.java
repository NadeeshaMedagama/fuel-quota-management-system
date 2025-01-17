package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.service.vehicalService.VehicleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final VehicleServiceRepository vehicleServiceRepository;

    @Autowired
    public VehicleController(VehicleServiceRepository vehicleServiceRepository) {
        this.vehicleServiceRepository = vehicleServiceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleRequestDTO vehicleRequestDTO){
        return vehicleServiceRepository.createVehicle(vehicleRequestDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicle(){
        return vehicleServiceRepository.getAllVehicle();
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> findVehicleById(@PathVariable int vehicleId){
        return vehicleServiceRepository.findVehicleById(vehicleId);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<?> updateVehicleCurrentFuelCapacity(
            @PathVariable int vehicleId,
            @RequestBody Map<String,Double> requestBody
    )
    {
        Double fuelCapacity = requestBody.get("fuelCapacity");
        return vehicleServiceRepository.updateVehicleCurrentFuelCapacity(vehicleId,fuelCapacity);
    }

@DeleteMapping("/{vehicleId}")
public ResponseEntity<?> deleteVehicle(int vehicleId) {
    return vehicleServiceRepository.deleteVehicle(vehicleId);
}

}
