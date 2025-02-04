package com.FuelBackend.dataTransferObject.request.FuelTransactionRequestDTO;

import java.time.LocalDateTime;

public class FuelTransactionDTO {
    private Long transactionId;
    private double transactionAmount;
    private LocalDateTime transactionDate;
    private String fuelType;
    private Integer vehicleId;
    private Long stationId;

    public FuelTransactionDTO(Long transactionId, double transactionAmount, LocalDateTime transactionDate, String fuelType, Integer vehicleId, Long stationId) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.fuelType = fuelType;
        this.vehicleId = vehicleId;
        this.stationId = stationId;
    }

    // Getters and Setters
}
