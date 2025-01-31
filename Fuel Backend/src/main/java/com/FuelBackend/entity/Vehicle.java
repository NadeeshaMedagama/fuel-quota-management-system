package com.FuelBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.springframework.lang.Nullable;

@Entity
@Table(
        name = "vehicle",
        indexes = {
                @Index(name = "idx_vehicle_number", columnList = "vehicleNumber"),
                @Index(name = "idx_vehicle_engine_no", columnList = "vehicleEngineNo")
        }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private int vehicleId;

    @Column(updatable = false, unique = true, nullable = false)
    private String vehicleNumber;

    @Column(updatable = false, unique = true, nullable = false)
    private String vehicleEngineNo;

    @Column(nullable = false)
    private Integer ownerId;

    @Column
    private String password;

    @Column(nullable = false)
    private String vehicleType;  // Replaced vehicleClass entity with String vehicleType

    @Column
    private Double fuelQuota;  // Fuel quota will be set in service layer

    @Column
    @Min(0)
    private Double currentFuelCapacity;

    @Lob
    private byte[] qrCode;

    public Vehicle() {
    }

    public Vehicle(String vehicleNumber, String vehicleEngineNo, Integer ownerId, String vehicleType, String password) {}

    public Vehicle(
            String vehicleNumber,
            String vehicleEngineNo,
            Integer ownerId,
            String vehicleType

    ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleEngineNo = vehicleEngineNo;
        this.ownerId = ownerId;
        this.vehicleType = vehicleType;
    }

    // Getters and Setters
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleEngineNo() {
        return vehicleEngineNo;
    }

    public void setVehicleEngineNo(String vehicleEngineNo) {
        this.vehicleEngineNo = vehicleEngineNo;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getFuelQuota() {
        return fuelQuota;
    }

    public void setFuelQuota(Double fuelQuota) {
        this.fuelQuota = fuelQuota;
    }

    public Double getCurrentFuelCapacity() {
        return currentFuelCapacity;
    }

    public void setCurrentFuelCapacity(Double currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }
}
