package com.FuelBackend.service.FuelTransactionService;

import com.FuelBackend.entity.FuelTransactionDetails;
import com.FuelBackend.repositoryDAO.FuelTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTransactionService {

    private final FuelTransactionRepository repository;

    public FuelTransactionService(FuelTransactionRepository repository) {
        this.repository = repository;
    }

    public List<FuelTransactionDetails> getAllTransactions() {
        return repository.findAll();
    }

    public List<FuelTransactionDetails> getTransactionsByVehicle(String vehicleNumber) {
        return repository.findByVehicle_VehicleNumberContainingIgnoreCase(vehicleNumber);
    }

    public List<FuelTransactionDetails> getTransactionsByStation(String stationName) {
        return repository.findByStation_StationNameContainingIgnoreCase(stationName);
    }

    public FuelTransactionDetails addTransaction(FuelTransactionDetails transaction) {
        return repository.save(transaction);
    }
}
