package com.FuelBackend.entity;

import com.FuelBackend.enums.VehicleClassName;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicle_classes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer vehicleClassId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private VehicleClassName vehicleClassName;

    public VehicleClasses(com.FuelBackend.enums.VehicleClassName vehicleClassName, Double maxFuelCapacityPerWeek, Double maxFuelCapacityPerWeekForBusinessGov) {
    }

    public enum VehicleClassName {
        CAR, BIKE, TRUCK
    }

    @Column(nullable = false)
    @Min(0)
    private Double maxFuelCapacityPerWeek;

    @Column(nullable = false)
    @Min(0)
    private Double maxFuelCapacityPerWeekForBusinessGov;

    @ManyToOne
    @JoinColumn(name = "fuel_id", referencedColumnName = "fuelId")
    private Fuel fuel;

    public Double getMaxFuelCapacityPerWeek() {
        return maxFuelCapacityPerWeek;
    }

    public void setMaxFuelCapacityPerWeek(Double maxFuelCapacityPerWeek) {
        this.maxFuelCapacityPerWeek = maxFuelCapacityPerWeek;
    }

    public Integer getVehicleClassId() {
        return vehicleClassId;
    }

    public void setVehicleClassId(Integer vehicleClassId) {
        this.vehicleClassId = vehicleClassId;
    }

    public VehicleClassName getVehicleClassName() {
        return vehicleClassName;
    }

    public void setVehicleClassName(VehicleClassName vehicleClassName) {
        this.vehicleClassName = vehicleClassName;
    }

    public Double getMaxFuelCapacityPerWeekForBusinessGov() {
        return maxFuelCapacityPerWeekForBusinessGov;
    }

    public void setMaxFuelCapacityPerWeekForBusinessGov(Double maxFuelCapacityPerWeekForBusinessGov) {
        this.maxFuelCapacityPerWeekForBusinessGov = maxFuelCapacityPerWeekForBusinessGov;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }
}
