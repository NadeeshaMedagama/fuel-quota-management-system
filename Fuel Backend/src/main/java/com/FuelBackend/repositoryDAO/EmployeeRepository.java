package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Object> findByEmployeeUsername(String username);
}
