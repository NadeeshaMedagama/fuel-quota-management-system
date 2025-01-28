package com.FuelBackend.entity;

import jakarta.persistence.*;

@Entity
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
