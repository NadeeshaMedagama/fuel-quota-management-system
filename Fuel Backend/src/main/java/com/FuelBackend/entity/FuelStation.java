package com.FuelBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "fuel_station_register")
public class FuelStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fuelStationId;

    @NotNull(message = "Location is required")
    private String location;

    @NotNull(message = "Station name is required")
    @Size(min = 3, max = 50, message = "Station name must be between 3 and 50 characters")
    private String stationName;

    @NotNull(message = "license number is required")
    private String licenseNumber;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Contact number is required")

    private String contactNumber;
    private String password;

    public FuelStation(String fuelStationLicenseNumber, String fuelStationOwnerName, String fuelStationEmail, String password) {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Column
    private String ownerName;

//    // Repeat for other fields
//    @ElementCollection
//    @CollectionTable(name = "fuel_station_inventory", joinColumns = @JoinColumn(name = "fuel_station_id"))
//    @MapKeyColumn(name = "fuel_type")
//    @Column(name = "available_fuel")
//    private Map<String, Double> fuelInventory;


    // Getter and Setter for id


    public Long getFuelStationId() {
        return fuelStationId;
    }

    public void setFuelStationId(Long fuelStationId) {
        this.fuelStationId = fuelStationId;
    }

    // Getter and Setter for location
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getter and Setter for stationName
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for contactNumber
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "FuelStationRegister{" +
                "id=" + fuelStationId +
                ", location='" + location + '\'' +
                ", stationName='" + stationName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", lisenceNumber='" + licenseNumber + '\'' +
                '}';
    }
}
