package com.FuelBackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter

public class FuelTransactionDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private double transactionAmount;

    private LocalDateTime transactionDate;

    private String fuelType;
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;



    @ManyToOne
    @JoinColumn(name = "station_id")
    private FuelStation station;

    public FuelTransactionDetails() {
    }

    public FuelTransactionDetails(Vehicle vehicleId, double transactionAmount, LocalDateTime transactionDate, FuelStation stationId) {

        this.vehicle = vehicleId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.station = stationId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public FuelStation getStation() {
        return station;
    }

    public void setStation(FuelStation station) {
        this.station = station;
    }
}
