package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.VehicleResponseDTO;
import com.FuelBackend.entity.Vehicle;
import com.FuelBackend.repositoryDAO.VehicleRepository;
import com.FuelBackend.service.vehicalService.VehicleServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
    @Autowired
    private final VehicleRepository vehicleRepository;

    @Autowired
    private final VehicleServiceRepository vehicleServiceRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository, VehicleServiceRepository vehicleServiceRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleServiceRepository = vehicleServiceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody VehicleResponseDTO vehicleRequestDTO) {
        return vehicleServiceRepository.createVehicle(vehicleRequestDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicle() {
        return vehicleServiceRepository.getAllVehicle();
    }

    @GetMapping("/{vehicleId}")
    public ResponseEntity<?> findVehicleById(@PathVariable int vehicleId) {
        return vehicleServiceRepository.findVehicleById(vehicleId);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<?> updateVehicleCurrentFuelCapacity(
            @PathVariable int vehicleId,
            @RequestBody Map<String, Double> requestBody
    ) {
        Double fuelCapacity = requestBody.get("fuelCapacity");
        return vehicleServiceRepository.updateVehicleCurrentFuelCapacity(vehicleId, fuelCapacity);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(int vehicleId) {
        return vehicleServiceRepository.deleteVehicle(vehicleId);
    }

    @GetMapping("/qr/{id}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)   .orElseThrow(() -> new RuntimeException("Vehicle not found."));
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(vehicle.getQrCode());
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerVehicle(@RequestBody VehicleResponseDTO vehicleRequestDTO) {
        boolean isValid = vehicleServiceRepository.validateVehicleDetails(vehicleRequestDTO);
        System.out.println(isValid);
        if (!isValid) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid vehicle details.");
        }

        String qrCodeUrl = vehicleServiceRepository.generateAndSaveQRCode(vehicleRequestDTO);
        return ResponseEntity.ok(Map.of(
                "message", "Vehicle registration successful.",
                "qrCodeUrl", qrCodeUrl
        ));
    }


}