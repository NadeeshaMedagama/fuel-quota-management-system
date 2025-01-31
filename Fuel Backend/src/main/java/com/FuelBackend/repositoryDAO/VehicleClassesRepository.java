package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.VehicleClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleClassesRepository extends JpaRepository<VehicleClasses, Integer> {
    Optional<VehicleClasses> findByVehicleClassName(String vehicleClassName);
}
