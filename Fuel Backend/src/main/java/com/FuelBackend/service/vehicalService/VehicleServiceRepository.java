package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.entity.VehicleClasses;
import org.springframework.http.ResponseEntity;

public interface VehicleServiceRepository {

    ResponseEntity<?> createVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> createBusinessGovVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> findVehicleById(int vehicleId);

    ResponseEntity<?> updateVehicleCurrentFuelCapacity(int vehicleId, Double fuelCapacity);

    ResponseEntity<?> updateVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> deleteVehicle(int vehicleId);

    ResponseEntity<?> getAllVehicle();

    public String generateAndSaveQRCode(VehicleRequestDTO vehicleRequestDTO);

    public  boolean validateVehicleDetails(VehicleRequestDTO vehicleRequestDTO);
}
