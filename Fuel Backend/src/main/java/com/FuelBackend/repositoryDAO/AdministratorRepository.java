package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer> {

    Optional<Administrator> findByAdministratorUsername(String administratorUsername);
}
