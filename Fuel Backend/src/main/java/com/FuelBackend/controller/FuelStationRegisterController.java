package com.FuelBackend.controller;

import com.FuelBackend.entity.FuelStation;
import com.FuelBackend.repositoryDAO.FuelStationRegisterRepository;
import com.FuelBackend.service.fuelStationRegistrationServices.FuelStationRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuelStation")
public class FuelStationRegisterController {
private final FuelStationRegisterService fuelStationRegisterService;

    public FuelStationRegisterController(FuelStationRegisterService fuelStationRegisterService) {
        this.fuelStationRegisterService = fuelStationRegisterService;
    }
@Autowired
    FuelStationRegisterRepository fuelStationRegisterRepository;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/register")
    public ResponseEntity<FuelStation> registerStation(@RequestBody FuelStation fuelStation) {

      FuelStation registeredStation= fuelStationRegisterService.registerFuelStation(fuelStation);
        return new ResponseEntity<>(registeredStation, HttpStatus.CREATED);
    }
    @GetMapping("/test")
    public ResponseEntity<List<FuelStation>> testConnection() {
        return new ResponseEntity<>(fuelStationRegisterRepository.findAll(), HttpStatus.OK);
}}
