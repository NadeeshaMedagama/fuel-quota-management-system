package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.DmtOffice;
import com.FuelBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DmtOfficeRepository extends JpaRepository<DmtOffice,Long > {

    @Query("SELECT vehicleNumber FROM DmtOffice")
    List<String> findAllVehicleNumbers();
}
