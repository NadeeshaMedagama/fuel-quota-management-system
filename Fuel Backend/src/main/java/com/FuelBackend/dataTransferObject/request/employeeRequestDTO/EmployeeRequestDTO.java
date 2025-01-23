package com.FuelBackend.dataTransferObject.request.employeeRequestDTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class EmployeeRequestDTO {

    @NotBlank(message = "employeeUsername is required")
    private String employeeUsername;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "employeeEmail is required")
    @Email
    private String employeeEmail;

    @NotBlank(message = "fuelStationId is required")
    private int fuelStationId;
    public EmployeeRequestDTO(String employeeUsername, String password, String employeeEmail, int fuelStationId) {
        this.employeeUsername = employeeUsername;
        this.password = password;
        this.employeeEmail = employeeEmail;
        this.fuelStationId = fuelStationId;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
