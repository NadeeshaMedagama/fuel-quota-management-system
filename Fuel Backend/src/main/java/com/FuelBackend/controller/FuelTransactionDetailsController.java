package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.FuelTransactionRequestDTO.FuelTransactionDTO;
import com.FuelBackend.entity.FuelTransactionDetails;

import com.FuelBackend.repositoryDAO.FuelTransactionRepository;
import com.FuelBackend.service.FuelTransactionService.FuelTransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin(origins = "http://localhost:3000")
public class FuelTransactionDetailsController {

    private final FuelTransactionRepository transactionRepository;
    private final FuelTransactionService transactionService;


    public FuelTransactionDetailsController(FuelTransactionRepository transactionRepository, FuelTransactionService transactionService) {
        this.transactionRepository = transactionRepository;
        this.transactionService = transactionService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<FuelTransactionDetails> getAllTransactions() {
 return transactionService.getAllTransactions();
    }

    @GetMapping("/vehicle/{registerNumber}")
    public List<FuelTransactionDetails> getTransactionsByVehicle(@PathVariable String registerNumber) {
        return transactionService.getTransactionsByVehicle(registerNumber);
    }

    @GetMapping("/station/{stationName}")
    public List<FuelTransactionDetails> getTransactionsByStation(@PathVariable String stationName) {
        return transactionService.getTransactionsByStation(stationName);
    }

    @PostMapping
    public FuelTransactionDetails addTransaction(@RequestBody FuelTransactionDetails transaction) {
        return transactionService.addTransaction(transaction);
    }
}
