package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface VehicleServiceRepository {

    public ResponseEntity<?> createVehicle(VehicleRequestDTO vehicleRequestDTO);

    public ResponseEntity<?> findVehicleById(int vehicleId);

    public ResponseEntity<?> updateVehicleCurrentFuelCapacity(int vehicleId, Double fuelCapacity);

    public ResponseEntity<?> updateVehicle(VehicleRequestDTO vehicleRequestDTO);

    public ResponseEntity<?> deleteVehicle(int vehicleId);

    public ResponseEntity<?> getAllVehicle();
}
