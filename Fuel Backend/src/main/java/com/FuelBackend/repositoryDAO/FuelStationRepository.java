package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelStationRepository extends JpaRepository<FuelStation, Integer> {
    Optional<Object> findByLicenseNumber(String licenseNumber);
}
