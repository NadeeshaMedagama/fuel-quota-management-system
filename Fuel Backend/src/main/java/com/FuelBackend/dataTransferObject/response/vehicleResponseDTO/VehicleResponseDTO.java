package com.FuelBackend.dataTransferObject.response.vehicleResponseDTO;

import com.FuelBackend.entity.VehicleClasses;

public class VehicleResponseDTO {

    private int vehicleId;

    private String vehicleRegisterId;

    private String vehicleEngineNo;



    private Double currentFuelCapacity;

    private Integer userId;


    private Integer vehicleClassId;

    private Integer fuelId;

    public VehicleResponseDTO(int vehicleId, String vehicleNumber, String vehicleEngineNo, Integer ownerId, VehicleClasses.VehicleClassName vehicleClass, Double fuelQuota){}

    public VehicleResponseDTO(
            int vehicleId,
            String vehicleRegisterId,
            String vehicleEngineNo,
            Integer userId,
            Integer vehicleClassId,
            Integer fuelId
    ) {
        this.vehicleId = vehicleId;
        this.vehicleRegisterId = vehicleRegisterId;
        this.vehicleEngineNo = vehicleEngineNo;
        this.currentFuelCapacity = currentFuelCapacity;
        this.userId = userId;
        this.vehicleClassId = vehicleClassId;
        this.fuelId = fuelId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
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


    public Double getCurrentFuelCapacity() {
        return currentFuelCapacity;
    }

    public void setCurrentFuelCapacity(Double currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVehicleClassId() {
        return vehicleClassId;
    }

    public void setVehicleClassId(Integer vehicleClassId) {
        this.vehicleClassId = vehicleClassId;
    }

    public Integer getFuelId() {
        return fuelId;
    }

    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
    }
}
