package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.vehicleClassesRequestDTO.VehicleClassesRequestDTO;
import com.FuelBackend.service.vehicleClassesService.VehicleClassesServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/vehicleClass")
public class VehicleClassesController {

    private final VehicleClassesServiceRepository vehicleClassesServiceRepository;

    @Autowired
    public VehicleClassesController(VehicleClassesServiceRepository vehicleClassesServiceRepository) {
        this.vehicleClassesServiceRepository = vehicleClassesServiceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createVehicleClass(@RequestBody VehicleClassesRequestDTO vehicleClassesRequestDTO){
        return vehicleClassesServiceRepository.createVehicleClass(vehicleClassesRequestDTO);
    }

    @PutMapping("/{vehicleClassId}")
    public ResponseEntity<?> updateVehicleClassMaxFuelCapacityPerWeek(
            @PathVariable Integer vehicleClassId,
            @RequestBody Map<String,Double> requestBody
    ){
        Double maxFuelCapacityPerWeek = requestBody.get("maxFuelCapacityPerWeek");
        return vehicleClassesServiceRepository.updateVehicleClassMaxFuelCapacityPerWeek(
                vehicleClassId,
                maxFuelCapacityPerWeek
        );
    }

    @PutMapping("/updateBusinessGovMaxFuel/{vehicleClassId}")
    public ResponseEntity<?> updateVehicleClassMaxFuelCapacityPerWeekForBusinessGov(
            @PathVariable Integer vehicleClassId,
            @RequestBody Map<String,Double> requestBody
    ){
        Double maxFuelCapacityPerWeekForBusinessGov = requestBody.get("maxFuelCapacityPerWeekForBusinessGov");
        return vehicleClassesServiceRepository.updateVehicleClassMaxFuelCapacityPerWeekForBusinessGov(
                vehicleClassId,
                maxFuelCapacityPerWeekForBusinessGov
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllVehicleClasses(){
        return vehicleClassesServiceRepository.getAllVehicleClasses();
    }

    @GetMapping("/{vehicleClassId}")
    public ResponseEntity<?> vehicleClassFindById(@PathVariable Integer vehicleClassId){
        return vehicleClassesServiceRepository.vehicleClassFindById(vehicleClassId);
    }

}
