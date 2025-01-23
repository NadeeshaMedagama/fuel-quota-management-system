package com.FuelBackend.dataTransferObject.response.employeeResponseDTO;

public class EmployeeResponseDTO {

    private int employeeId;
    private String employeeUsername;


    private String employeeEmail;


    private Long fuelStationId;

    private Boolean employeeStatus;

    public EmployeeResponseDTO(int employeeId, String employeeUsername, String employeeEmail, Long fuelStationId, Boolean employeeStatus) {
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

    public Long getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(Long fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    public Boolean getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Boolean employeeStatus) {
        this.employeeStatus = employeeStatus;
    }
}
