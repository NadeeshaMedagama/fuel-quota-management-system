package com.FuelBackend.service.dashboard;

import com.FuelBackend.repositoryDAO.EmployeeRepository;
import com.FuelBackend.repositoryDAO.FuelStationRepository;
import com.FuelBackend.repositoryDAO.UserRepository;
import com.FuelBackend.repositoryDAO.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FuelStationRepository fuelStationRepository;
    @Autowired
    private UserRepository userRepository;

    public long getTotalVehicles() {
        return vehicleRepository.count();
    }

    public long getTotalEmployees() {
        return employeeRepository.count();
    }

    public long getTotalFuelStations() {
        return fuelStationRepository.count();
    }

    public long getTotalUsers() {
        return userRepository.count();
    }
}
