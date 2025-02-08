package com.FuelBackend.dataTransferObject.response.fuelStationResponseDTO;


public class FuelStationResponseDTO {

    private Long fuelStationId;

    private String fuelStationRegisterId;

    private String fuelStationName;

    private String fuelStationEmail;

    public FuelStationResponseDTO(Long fuelStationId, String fuelStationRegisterId, String fuelStationName, String fuelStationEmail) {
        this.fuelStationId = fuelStationId;
        this.fuelStationRegisterId = fuelStationRegisterId;
        this.fuelStationName = fuelStationName;
        this.fuelStationEmail = fuelStationEmail;
    }

    public Long getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(Long fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    public String getFuelStationRegisterId() {
        return fuelStationRegisterId;
    }

    public void setFuelStationRegisterId(String fuelStationRegisterId) {
        this.fuelStationRegisterId = fuelStationRegisterId;
    }

    public String getFuelStationName() {
        return fuelStationName;
    }

    public void setFuelStationName(String fuelStationName) {
        this.fuelStationName = fuelStationName;
    }

    public String getFuelStationEmail() {
        return fuelStationEmail;
    }

    public void setFuelStationEmail(String fuelStationEmail) {
        this.fuelStationEmail = fuelStationEmail;
    }
}
