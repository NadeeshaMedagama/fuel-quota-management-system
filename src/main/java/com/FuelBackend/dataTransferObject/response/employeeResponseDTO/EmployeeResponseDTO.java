package com.FuelBackend.dataTransferObject.response.employeeResponseDTO;

import java.util.UUID;

public class EmployeeResponseDTO {

    private int employeeId;
    private String employeeUsername;


    private String employeeEmail;


    private int fuelStationId;

    private Boolean employeeStatus;

    public EmployeeResponseDTO(int employeeId, String employeeUsername, String employeeEmail, int fuelStationId, Boolean employeeStatus) {
        this.employeeId = employeeId;
        this.employeeUsername = employeeUsername;
        this.employeeEmail = employeeEmail;
        this.fuelStationId = fuelStationId;
        this.employeeStatus = employeeStatus;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }


    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public int getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(int fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    public Boolean getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
