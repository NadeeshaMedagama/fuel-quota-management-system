package com.FuelBackend.service.FuelReportService;

import com.FuelBackend.entity.FuelTransactionDetails;
import com.FuelBackend.repositoryDAO.FuelTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FuelReportService {
    private final FuelTransactionRepository fuelTransactionRepository;

    public FuelReportService(FuelTransactionRepository fuelTransactionRepository) {
        this.fuelTransactionRepository = fuelTransactionRepository;
    }

    public List<FuelTransactionDetails> getFuelReport(String fuelType, String period) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate;

        switch (period.toLowerCase()) {
            case "weekly":
                startDate = endDate.minusWeeks(1);
                break;
            case "monthly":
                startDate = endDate.minusMonths(1);
                break;
            case "yearly":
                startDate = endDate.minusYears(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid period: " + period);
        }

        return fuelTransactionRepository.findByFuelTypeAndTransactionDateBetween(fuelType, startDate, endDate);
    }

}
