package com.FuelBackend.dataTransferObject.request.vehicleRequestDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.Nullable;

import java.util.Date;

public class VehicleRequestDTO {

    @NotBlank
    private String vehicleNumber;

    @NotBlank
    private String vehicleEngineNo;

    @NotBlank
    private Integer ownerId;

    @NotBlank
    private String password;

    @NotBlank
    private String vehicleType;



    public VehicleRequestDTO(String vehicleNumber, String vehicleEngineNo, Integer ownerId, String password, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleEngineNo = vehicleEngineNo;
        this.ownerId = ownerId;
        this.password = password;
        this.vehicleType = vehicleType;
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
}