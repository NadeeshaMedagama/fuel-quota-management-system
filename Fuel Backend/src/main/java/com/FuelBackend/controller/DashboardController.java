package com.FuelBackend.controller;

import com.FuelBackend.service.dashBoardService.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DashboardController {
    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/api/v1/dashboard-data")
    public Map<String, Long> getDashboardData() {
        return Map.of(
                "totalVehicles", dashboardService.getTotalVehicles(),
                "totalEmployees", dashboardService.getTotalEmployees(),
                "totalFuelStations", dashboardService.getTotalFuelStations(),
                "totalUsers", dashboardService.getTotalUsers()
        );
    }
}
