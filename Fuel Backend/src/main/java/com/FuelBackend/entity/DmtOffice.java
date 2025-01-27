package com.FuelBackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DmtOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vehicleNumber;

    @Column(unique = true, nullable = false)
    private String vehicleEngineNo;

    private String vehicleType;

    private String ownerName;

    private String fuelType;

}
