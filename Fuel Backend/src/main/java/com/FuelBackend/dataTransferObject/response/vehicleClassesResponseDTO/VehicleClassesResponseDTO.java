package com.FuelBackend.dataTransferObject.response.vehicleClassesResponseDTO;

import com.FuelBackend.entity.VehicleClasses;
import com.FuelBackend.enums.VehicleClassName;

public class VehicleClassesResponseDTO {

    private Integer vehicleClassId;
    private VehicleClassName vehicleClassName;

    private Double maxFuelCapacityPerWeek;

    private Double maxFuelCapacityPerWeekForBusinessGov;

//    private Integer fuelId;


    public VehicleClassesResponseDTO(Integer vehicleClassId, VehicleClasses.VehicleClassName vehicleClassName, Double maxFuelCapacityPerWeek, Double maxFuelCapacityPerWeekForBusinessGov) {
    }

    public VehicleClassesResponseDTO(
            Integer vehicleClassId,
            VehicleClassName vehicleClassName,
            Double maxFuelCapacityPerWeek,
            Double maxFuelCapacityPerWeekForBusinessGov
    ) {
        this.vehicleClassId = vehicleClassId;
        this.vehicleClassName = vehicleClassName;
        this.maxFuelCapacityPerWeek = maxFuelCapacityPerWeek;
        this.maxFuelCapacityPerWeekForBusinessGov = maxFuelCapacityPerWeekForBusinessGov;
//        this.fuelId = fuelId;
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

    //    public Integer getFuelId() {
//        return fuelId;
//    }
//
//    public void setFuelId(Integer fuelId) {
//        this.fuelId = fuelId;
//    }
}
