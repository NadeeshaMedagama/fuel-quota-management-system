package com.FuelBackend.controller;

import com.FuelBackend.entity.FuelTransactionDetails;
import com.FuelBackend.service.FuelTransactionService.FuelTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(origins = "http://localhost:3000") // Adjust for frontend
public class FuelTransactionDetailsController {

    private final FuelTransactionService service;

    public FuelTransactionDetailsController(FuelTransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<FuelTransactionDetails> getAllTransactions() {
        return service.getAllTransactions();
    }

    @GetMapping("/vehicle/{registerNumber}")
    public List<FuelTransactionDetails> getTransactionsByVehicle(@PathVariable String registerNumber) {
        return service.getTransactionsByVehicle(registerNumber);
    }

    @GetMapping("/station/{stationName}")
    public List<FuelTransactionDetails> getTransactionsByStation(@PathVariable String stationName) {
        return service.getTransactionsByStation(stationName);
    }

    @PostMapping
    public FuelTransactionDetails addTransaction(@RequestBody FuelTransactionDetails transaction) {
        return service.addTransaction(transaction);
    }
}
