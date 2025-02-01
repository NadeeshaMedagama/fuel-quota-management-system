package com.FuelBackend.service.userService;

import com.FuelBackend.dataTransferObject.request.userRequestDTO.UserRequestDTO;
import com.FuelBackend.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;


public interface UserServiceRepository {
    ResponseEntity<?> createUser(UserRequestDTO userRequestDTO);

    ResponseEntity<?> updateUser(UserRequestDTO userRequestDTO,Integer userId);

    ResponseEntity<?> findUserByID(Integer userId);

    ResponseEntity<?> deleteUser(Integer userId);

    ResponseEntity<?> verifyUserMobile(Integer userId, Integer otp);

    User registerUser(@Valid @RequestBody UserRequestDTO userDTO);
}
