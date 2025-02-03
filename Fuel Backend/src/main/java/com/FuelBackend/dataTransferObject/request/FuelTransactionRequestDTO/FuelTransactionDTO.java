package com.FuelBackend.dataTransferObject.request.FuelTransactionRequestDTO;

import java.time.LocalDateTime;

public class FuelTransactionDTO {
    private Long transactionId;
    private double transactionAmount;
    private LocalDateTime transactionDate;
    private String fuelType;
    private String vehicleRegisterNumber;
    private String stationName;


    public FuelTransactionDTO() {}

    public FuelTransactionDTO(Long transactionId, double transactionAmount, LocalDateTime transactionDate,
                              String fuelType, String vehicleRegisterNumber, String stationName) {
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.fuelType = fuelType;
        this.vehicleRegisterNumber = vehicleRegisterNumber;
        this.stationName = stationName;
    }


    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }

    public double getTransactionAmount() { return transactionAmount; }
    public void setTransactionAmount(double transactionAmount) { this.transactionAmount = transactionAmount; }

    public LocalDateTime getTransactionDate() { return transactionDate; }
    public void setTransactionDate(LocalDateTime transactionDate) { this.transactionDate = transactionDate; }

    public String getFuelType() { return fuelType; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    public String getVehicleRegisterNumber() { return vehicleRegisterNumber; }
    public void setVehicleRegisterNumber(String vehicleRegisterNumber) { this.vehicleRegisterNumber = vehicleRegisterNumber; }

    public String getStationName() { return stationName; }
    public void setStationName(String stationName) { this.stationName = stationName; }
}
