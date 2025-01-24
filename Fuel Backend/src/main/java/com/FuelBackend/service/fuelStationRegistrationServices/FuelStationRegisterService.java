package com.FuelBackend.service.fuelStationRegistrationServices;

import com.FuelBackend.entity.FuelStation;
import com.FuelBackend.repositoryDAO.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FuelStationRegisterService {

    @Autowired
    private FuelStationRepository fuelStationRepository;



    public FuelStation registerFuelStation(FuelStation fuelStation) {

        return fuelStationRepository.save(fuelStation);
    }
}
