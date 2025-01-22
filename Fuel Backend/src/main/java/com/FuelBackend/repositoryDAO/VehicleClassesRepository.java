package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.VehicleClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleClassesRepository extends JpaRepository<VehicleClasses, Integer> {
}
