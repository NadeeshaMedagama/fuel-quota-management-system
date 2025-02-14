package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.fuelStationRequestDTO.FuelStationRequestDTO;
import com.FuelBackend.service.FuelStationService.FuelStationService;
import com.FuelBackend.service.FuelStationService.FuelStationServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fuelStation")
@CrossOrigin(origins = "http://localhost:3000")
public class FuelStationController {

    private final FuelStationServiceRepository fuelStationServiceRepository;
    @Autowired
    private final FuelStationService fuelStationService;

    @Autowired
    public FuelStationController(FuelStationServiceRepository fuelStationServiceRepository, FuelStationService fuelStationService) {
        this.fuelStationServiceRepository = fuelStationServiceRepository;
        this.fuelStationService = fuelStationService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createFuelStation(@RequestBody FuelStationRequestDTO fuelStationRequestDTO){
        return fuelStationServiceRepository.createFuelStation(fuelStationRequestDTO);
    }

    @GetMapping("/{fuelStationId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getFuelStationById(@PathVariable int fuelStationId){
        return fuelStationServiceRepository.getFuelStationById(fuelStationId);
    }

    @PutMapping("/{fuelStationId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> updateFuelStation(@PathVariable int fuelStationId,@RequestBody FuelStationRequestDTO fuelStationRequestDTO){
        return fuelStationServiceRepository.updateFuelStation(fuelStationId,fuelStationRequestDTO);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getAllFuelStation(){
        return fuelStationServiceRepository.getAllFuelStation();
    }

    @DeleteMapping("/{fuelStationId}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> deleteFuelStation(@PathVariable int fuelStationId){
        return fuelStationServiceRepository.deleteFuelStation(fuelStationId);
    }

}
