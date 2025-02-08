package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.fuelRequestDTO.FuelRequestDTO;
import com.FuelBackend.entity.FuelTransactionDetails;
import com.FuelBackend.service.FuelReportService.FuelReportService;
import com.FuelBackend.service.fuelService.FuelServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/fuel")
public class FuelController {
    private final FuelReportService fuelReportService;

    private final FuelServiceRepository fuelServiceRepository;

    @Autowired
    public FuelController(FuelReportService fuelReportService, FuelServiceRepository fuelServiceRepository) {
        this.fuelReportService = fuelReportService;
        this.fuelServiceRepository = fuelServiceRepository;
    }

    @PostMapping
    public ResponseEntity<?> createFuel(@RequestBody FuelRequestDTO fuelRequestDTO){
        return fuelServiceRepository.createFuel(fuelRequestDTO);
    }

    @GetMapping
    public ResponseEntity<?> getAllFuel(){
        return fuelServiceRepository.getAllFuel();
    }

    @GetMapping("/{fuelId}")
    public ResponseEntity<?> findFuelById(@PathVariable Integer fuelId){
        return fuelServiceRepository.findFuelById(fuelId);
    }

    @PutMapping("/{fuelId}")
    public ResponseEntity<?> updateFuelPrice(@PathVariable Integer fuelId,@RequestBody Map<String, Double> requestBody){
        Double price = requestBody.get("price");
        return fuelServiceRepository.updateFuelPrice(fuelId,price);
    }

    @DeleteMapping("/{fuelId}")
    public ResponseEntity<?> DeleteFuelById(@PathVariable Integer fuelId){
        return fuelServiceRepository.DeleteFuelById(fuelId);
    }



    @GetMapping("/fuel-report")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getFuelReport(
            @RequestParam String fuelType,
            @RequestParam String period) {


        List<FuelTransactionDetails> reportData = fuelReportService.getFuelReport(fuelType, period);

        Map<String, Object> response = new HashMap<>();
        response.put("fuelType", fuelType);
        response.put("period", period);
        response.put("data", reportData);


        return ResponseEntity.ok(response);
    }
}
