package com.FuelBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(
        name = "vehicle",
        indexes = {
                @Index(name = "idx_vehicle_register_id", columnList = "vehicleRegisterId"),
                @Index(name = "idx_vehicle_engine_no", columnList = "vehicleEngineNo"),
                @Index(name = "idx_vehicle_class_id", columnList = "vehicleClassId")
        }
)
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vehicleId;

    @Column(updatable = false,unique = true,nullable = false)
    private String vehicleRegisterId;

    @Column(updatable = false,unique = true,nullable = false)
    private String vehicleEngineNo;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Date yearOfManufacture;

    @Column(nullable = true, columnDefinition = "double default 0")
    @Min(0)
    private Double currentFuelCapacity;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = true)
    private User user;

    @ManyToOne
    @JoinColumn(name= "business_government_id",referencedColumnName = "businessGovernmentId", nullable = true)
    private BusinessGovernment businessGovernment;

    @ManyToOne
    @JoinColumn(name = "vehicle_class_id", referencedColumnName = "vehicleClassId", nullable = false)
    private VehicleClasses vehicleClasses;

    @ManyToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "fuelId", nullable = false)
    private Fuel fuel;

    public Vehicle(){}

    public Vehicle(
                   String vehicleRegisterId,
                   String vehicleEngineNo,
                   String model,
                   Date yearOfManufacture,
                   User user,
                   BusinessGovernment businessGovernment,
                   VehicleClasses vehicleClasses,
                   Fuel fuel
    ) {
        this.vehicleRegisterId = vehicleRegisterId;
        this.vehicleEngineNo = vehicleEngineNo;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;

        this.user = user;
        this.businessGovernment = businessGovernment;
        this.vehicleClasses = vehicleClasses;
        this.fuel = fuel;
    }

    public Vehicle(
            UUID vehicleId,
            String vehicleRegisterId,
            String vehicleEngineNo,
            String model,
            Date yearOfManufacture,
            Double currentFuelCapacity,
            User user,
            BusinessGovernment businessGovernment,
            VehicleClasses vehicleClasses,
            Fuel fuel
    ) {
        this.vehicleId = vehicleId;
        this.vehicleRegisterId = vehicleRegisterId;
        this.vehicleEngineNo = vehicleEngineNo;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.currentFuelCapacity = currentFuelCapacity;
        this.user = user;
        this.businessGovernment = businessGovernment;
        this.vehicleClasses = vehicleClasses;
        this.fuel = fuel;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleRegisterId() {
        return vehicleRegisterId;
    }

    public void setVehicleRegisterId(String vehicleRegisterId) {
        this.vehicleRegisterId = vehicleRegisterId;
    }

    public String getVehicleEngineNo() {
        return vehicleEngineNo;
    }

    public void setVehicleEngineNo(String vehicleEngineNo) {
        this.vehicleEngineNo = vehicleEngineNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Date yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Double getCurrentFuelCapacity() {
        return currentFuelCapacity;
    }

    public void setCurrentFuelCapacity(Double currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public VehicleClasses getVehicleClasses() {
        return vehicleClasses;
    }

    public void setVehicleClasses(VehicleClasses vehicleClasses) {
        this.vehicleClasses = vehicleClasses;
    }

    public BusinessGovernment getBusinessGovernment() {
        return businessGovernment;
    }

    public void setBusinessGovernment(BusinessGovernment businessGovernment) {
        this.businessGovernment = businessGovernment;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
