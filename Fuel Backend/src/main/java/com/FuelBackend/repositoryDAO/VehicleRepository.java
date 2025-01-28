package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle , Integer> {

    @Query("SELECT v.vehicleNumber FROM Vehicle v")
    List<String> findAllVehicleNumber();
}
