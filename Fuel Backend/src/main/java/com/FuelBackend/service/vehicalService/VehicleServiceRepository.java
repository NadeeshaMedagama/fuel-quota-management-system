package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;

import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.VehicleResponseDTO;
import com.FuelBackend.entity.Vehicle;
import org.springframework.http.ResponseEntity;

public interface VehicleServiceRepository {

    ResponseEntity<?> createVehicle(VehicleResponseDTO vehicleRequestDTO);

    ResponseEntity<?> createBusinessGovVehicle(VehicleResponseDTO vehicleRequestDTO);

    ResponseEntity<?> findVehicleById(int vehicleId);

    ResponseEntity<?> updateVehicleCurrentFuelCapacity(int vehicleId, Double fuelCapacity);

    ResponseEntity<?> updateVehicle(VehicleResponseDTO vehicleRequestDTO);

    ResponseEntity<?> deleteVehicle(int vehicleId);

    ResponseEntity<?> getAllVehicle();

    public String generateAndSaveQRCode(VehicleResponseDTO vehicleRequestDTO);

    public  boolean validateVehicleDetails(VehicleResponseDTO vehicleRequestDTO);

    Vehicle registerVehicle(VehicleRequestDTO vehicleDTO);
}
