package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.BusinessGovernment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BusinessGovernmentRepository extends JpaRepository<BusinessGovernment, UUID> {
}
