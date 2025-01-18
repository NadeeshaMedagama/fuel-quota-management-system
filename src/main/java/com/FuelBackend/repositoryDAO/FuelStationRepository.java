package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelStationRepository extends JpaRepository<FuelStation, Integer> {
}
