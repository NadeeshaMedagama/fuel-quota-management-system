package com.FuelBackend.entity;

import com.FuelBackend.enums.OwnerType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.springframework.lang.Nullable;

@Entity
@Table(
        name = "vehicle",
        indexes = {
                @Index(name = "idx_vehicle_register_id", columnList = "vehicleRegisterId"),
                @Index(name = "idx_vehicle_engine_no", columnList = "vehicleEngineNo"),
                @Index(name = "idx_vehicle_class_id", columnList = "vehicleClassId")
        }
)
public class Vehicle {

    @Id
    @GeneratedValue
    @Nullable
    private int vehicleId;

    @Column(updatable = false,unique = true,nullable = false)
    private String vehicleNumber;

    @Column(updatable = false,unique = true,nullable = false)
    private String vehicleEngineNo;



    @Column
    private String password;


    @Column(nullable = false)
    private Integer ownerId;

    @Column

    private Double fuelQuota;

    @Column
    @Min(0)
    private Double currentFuelCapacity;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = true)
//    private User user;

//    @ManyToOne
//    @JoinColumn(name= "business_government_id",referencedColumnName = "businessGovernmentId", nullable = true)
//    private BusinessGovernment businessGovernment;


    @ManyToOne
    @JoinColumn(name = "vehicle_class_id", referencedColumnName = "vehicleClassId", nullable = false)
    private VehicleClasses.VehicleClassName vehicleClass;


    @Lob
    private byte[] qrCode;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "loginid", nullable = false)
//    private UserLog ownerLog;

    public Vehicle(String vehicleRegisterId, String vehicleEngineNo, Integer ownerId, Integer vehicleClass, Integer fuel) {
    }

    public byte[] getQrCode() {
        return qrCode;
    }

    public void setQrCode(byte[] qrCode) {
        this.qrCode = qrCode;
    }

    public Vehicle(String vehicleRegisterId, String vehicleEngineNo, OwnerType user, Integer ownerId, VehicleClasses vehicleClass, Fuel fuel){}



    public Vehicle(
            int vehicleId,
            String vehicleNumber,
            String vehicleEngineNo,
            Double currentFuelCapacity,
           Double fuelQuota
    ) {
        this.vehicleId = vehicleId;
        this.vehicleNumber =vehicleNumber;
        this.vehicleEngineNo = vehicleEngineNo;
        this.currentFuelCapacity = currentFuelCapacity;
       this.fuelQuota=fuelQuota;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    public Double getCurrentFuelCapacity() {
        return currentFuelCapacity;
    }

    public void setCurrentFuelCapacity(Double currentFuelCapacity) {
        this.currentFuelCapacity = currentFuelCapacity;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public VehicleClasses.VehicleClassName getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(VehicleClasses.VehicleClassName vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Double getFuelQuota() {
        return fuelQuota;
    }

    public void setFuelQuota(Double fuelQuota) {
        this.fuelQuota = fuelQuota;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

}
