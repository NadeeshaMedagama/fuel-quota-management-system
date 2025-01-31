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


}
