package com.FuelBackend.service.fuelService;

import com.FuelBackend.dataTransferObject.request.fuelRequestDTO.FuelRequestDTO;
import com.FuelBackend.exception.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface FuelServiceRepository {

    public ResponseEntity<?> createFuel(FuelRequestDTO fuelRequestDTO);

    public ResponseEntity<?> findFuelById(Integer fuelId);

    public ResponseEntity<?> updateFuelPrice(Integer fuelId, Double price);

    public ResponseEntity<?> DeleteFuelById(Integer fuelId);

    public ResponseEntity<?> getAllFuel();

}
