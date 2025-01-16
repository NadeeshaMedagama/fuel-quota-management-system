package com.FuelBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@Table(
        name = "vehicle_classes"
)
public class VehicleClasses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer vehicleClassId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    @NotNull
    private VehicleClassName vehicleClassName;

    public VehicleClasses() {
    }

    public enum VehicleClassName {
        CAR,
        TRUCK,
        MOTORCYCLE,
        VAN
    }

    @Column
    @NotNull
    @Min(0)
    private Double maxFuelCapacityPerWeek;

    @Column
    @NotNull
    @Min(0)
    private Double maxFuelCapacityPerWeekForBusinessGov;

    // Custom constructor without Lombok for specific use cases
    public VehicleClasses(
            VehicleClassName vehicleClassName,
            Double maxFuelCapacityPerWeek,
            Double maxFuelCapacityPerWeekForBusinessGov
    ) {
        this.vehicleClassName = vehicleClassName;
        this.maxFuelCapacityPerWeek = maxFuelCapacityPerWeek;
        this.maxFuelCapacityPerWeekForBusinessGov = maxFuelCapacityPerWeekForBusinessGov;
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

    public Double getMaxFuelCapacityPerWeek() {
        return maxFuelCapacityPerWeek;
    }

    public void setMaxFuelCapacityPerWeek(Double maxFuelCapacityPerWeek) {
        this.maxFuelCapacityPerWeek = maxFuelCapacityPerWeek;
    }

    public Double getMaxFuelCapacityPerWeekForBusinessGov() {
        return maxFuelCapacityPerWeekForBusinessGov;
    }

    public void setMaxFuelCapacityPerWeekForBusinessGov(Double maxFuelCapacityPerWeekForBusinessGov) {
        this.maxFuelCapacityPerWeekForBusinessGov = maxFuelCapacityPerWeekForBusinessGov;
    }
}
