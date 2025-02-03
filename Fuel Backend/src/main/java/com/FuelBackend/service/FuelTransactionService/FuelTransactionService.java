package com.FuelBackend.service.FuelTransactionService;

import com.FuelBackend.dataTransferObject.request.FuelTransactionRequestDTO.FuelTransactionDTO;
import com.FuelBackend.entity.FuelTransactionDetails;
import com.FuelBackend.repositoryDAO.FuelTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<FuelTransactionDTO> convertToDTOList(List<FuelTransactionDetails> transactions) {
        return transactions.stream().map(transaction ->
                new FuelTransactionDTO(
                        transaction.getTransactionId(),
                        transaction.getTransactionAmount(),
                        transaction.getTransactionDate(),
                        transaction.getFuelType(),
                        transaction.getVehicle() != null ? transaction.getVehicle().getVehicleId() : null,
                        transaction.getStation() != null ? transaction.getStation().getFuelStationId() : null
                )).collect(Collectors.toList());
    }
}
