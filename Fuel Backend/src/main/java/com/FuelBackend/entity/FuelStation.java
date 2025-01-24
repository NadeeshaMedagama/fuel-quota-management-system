package com.FuelBackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class FuelStation {

    @Id
    @Column(nullable = false)
    private Long fuelStationId;

    @Column(nullable = false,unique = true,updatable = false)
    private String fuelStationRegisterId;

    @Column(nullable = false)
    private String fuelStationOwnerName;

    @Column(nullable = false,unique = true)
    @Email
    private String fuelStationEmail;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "fuelStation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    public FuelStation(){

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public FuelStation(
            String fuelStationRegisterId,
            String fuelStationOwnerName,
            String fuelStationEmail,
            String password
    ) {
        this.fuelStationRegisterId = fuelStationRegisterId;
        this.fuelStationOwnerName = fuelStationOwnerName;
        this.fuelStationEmail = fuelStationEmail;
        this.password = password;
    }

    public FuelStation(
        Long fuelStationId,
            String fuelStationRegisterId,
            String fuelStationOwnerName,
            String fuelStationEmail,
            String password
    ) {
        this.fuelStationId = fuelStationId;
        this.fuelStationRegisterId = fuelStationRegisterId;
        this.fuelStationOwnerName = fuelStationOwnerName;
        this.fuelStationEmail = fuelStationEmail;
        this.password = password;
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

    public String getFuelStationOwnerName() {
        return fuelStationOwnerName;
    }

    public void setFuelStationOwnerName(String fuelStationOwnerName) {
        this.fuelStationOwnerName = fuelStationOwnerName;
    }

    public String getFuelStationEmail() {
        return fuelStationEmail;
    }

    public void setFuelStationEmail(String fuelStationEmail) {
        this.fuelStationEmail = fuelStationEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
