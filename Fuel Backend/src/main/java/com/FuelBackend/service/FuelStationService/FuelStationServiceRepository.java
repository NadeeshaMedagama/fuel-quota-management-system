package com.FuelBackend.service.FuelStationService;

import com.FuelBackend.dataTransferObject.request.fuelStationRequestDTO.FuelStationRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface FuelStationServiceRepository {

    public ResponseEntity<?> createFuelStation(FuelStationRequestDTO fuelStationRequestDTO);

    public ResponseEntity<?> getFuelStationById(int fuelStationId);

    public ResponseEntity<?> updateFuelStation(int fuelStationId, FuelStationRequestDTO fuelStationRequestDTO);

    public ResponseEntity<?> deleteFuelStation(int fuelStationId);

    public ResponseEntity<?> getAllFuelStation();
}
