package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface VehicleServiceRepository {

    ResponseEntity<?> createVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> createBusinessGovVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> findVehicleById(UUID vehicleId);

    ResponseEntity<?> updateVehicleCurrentFuelCapacity(UUID vehicleId, Double fuelCapacity);

    ResponseEntity<?> updateVehicle(VehicleRequestDTO vehicleRequestDTO);

    ResponseEntity<?> deleteVehicle(UUID vehicleId);

    ResponseEntity<?> getAllVehicle();
}
