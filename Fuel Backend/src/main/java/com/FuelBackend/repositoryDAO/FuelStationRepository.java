package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface FuelStationRepository extends JpaRepository<FuelStation, Integer> {
    Optional<Object> findByFuelStationRegisterId(String fuelStationRegisterId);
}
