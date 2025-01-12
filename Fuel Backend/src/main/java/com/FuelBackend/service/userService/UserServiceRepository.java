package com.FuelBackend.service.userService;

import com.FuelBackend.dataTransferObject.request.userRequestDTO.UserRequestDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


public interface UserServiceRepository {
    ResponseEntity<?> createUser(UserRequestDTO userRequestDTO);

    ResponseEntity<?> updateUser(UserRequestDTO userRequestDTO,Integer userId);

    ResponseEntity<?> findUserByID(Integer userId);

    ResponseEntity<?> deleteUser(Integer userId);

    ResponseEntity<?> verifyUserMobile(Integer userId, Integer otp);
}
