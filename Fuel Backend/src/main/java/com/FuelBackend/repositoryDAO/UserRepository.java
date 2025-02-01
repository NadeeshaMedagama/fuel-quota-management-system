package com.FuelBackend.repositoryDAO;

import com.FuelBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User>  findByContactNumber(String contactNumber);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}
