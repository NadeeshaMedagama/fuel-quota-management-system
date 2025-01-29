package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelStationRegisterRepository extends JpaRepository<FuelStation, Long> {
}

