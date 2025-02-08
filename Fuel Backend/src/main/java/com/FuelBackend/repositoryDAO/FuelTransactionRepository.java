package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.FuelTransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FuelTransactionRepository extends JpaRepository<FuelTransactionDetails,Long> {
    public abstract List<FuelTransactionDetails> findByFuelTypeAndTransactionDateBetween(String fuelType, LocalDateTime startDate, LocalDateTime endDate);

    List<FuelTransactionDetails> findByVehicle_VehicleNumberContainingIgnoreCase(String vehicleNumber);

    List<FuelTransactionDetails> findByStation_StationNameContainingIgnoreCase(String stationName);
}
