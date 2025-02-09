package com.FuelBackend.service.userService;

import com.FuelBackend.dataTransferObject.request.userRequestDTO.UserRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.userResponseDTO.UserResponseDTO;
import com.FuelBackend.entity.User;
import com.FuelBackend.repositoryDAO.UserRepository;
import com.FuelBackend.service.otpService.OtpServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceRepository{

    private final UserRepository userRepository;

    private final OtpServiceRepository otpServiceRepository;

    @Autowired
    public UserService (UserRepository userRepository, OtpServiceRepository otpServiceRepository){
        this.userRepository= userRepository;
        this.otpServiceRepository = otpServiceRepository;
    }

    @Override
    public ResponseEntity<?> createUser(UserRequestDTO userRequestDTO) {
        User user = new User(
                userRequestDTO.getFullName(),
                userRequestDTO.getAddress(),
                userRequestDTO.getContactNumber(),
                userRequestDTO.getPassword(),
                userRequestDTO.getUsername(),
                userRequestDTO.getUserType()
        );

        User savedUser = userRepository.save(user);
        otpServiceRepository.sendOtp(savedUser.getMobile());
        UserResponseDTO responseData = new UserResponseDTO(
                savedUser.getFullName(),
                savedUser.getAddress(),
                savedUser.getContactNumber(),
                savedUser.getUserType(),
                savedUser.getPassword(),
                savedUser.getUsername()
        );
        CustomApiResponse response =new CustomApiResponse(
                HttpStatus.CREATED.value(),
                "user created successfully"
        );
        return new ResponseEntity<>(response,HttpStatus.CREATED);

    }

    @Override
    @Transactional
    public ResponseEntity<?> updateUser(UserRequestDTO userRequestDTO, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found")
        );
        user.setFullName(userRequestDTO.getFullName());
        user.setUserType(userRequestDTO.getUserType());
        user.setAddress(userRequestDTO.getAddress());
        user.setContactNumber(userRequestDTO.getContactNumber());
        user.setPassword(userRequestDTO.getPassword());

        User updatedUser = userRepository.save(user);
        UserResponseDTO responseData = new UserResponseDTO(
                updatedUser.getFullName(),
                updatedUser.getAddress(),
                updatedUser.getUserType(),
                updatedUser.getContactNumber(),
                updatedUser.getPassword(),
                updatedUser.getUsername()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "user updated successfully"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "user deleted successfully"
                ),
                HttpStatus.OK

        );
    }

    @Override
    public ResponseEntity<?> findUserByID(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("user not found")
        );

        UserResponseDTO response = new UserResponseDTO(
                user.getFullName(),
                user.getAddress(),
                user.getUserType(),
              user.getContactNumber(),
                user.getPassword(),
               user.getUsername()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "user founded"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> verifyUserMobile(Integer userId, Integer otp) {
        return null;
    }


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserRequestDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            throw new RuntimeException("Username is already taken.");
        }

        User user = new User();
        user.setFullName(userDTO.getFullName());
        user.setAddress(userDTO.getAddress());
        user.setContactNumber(userDTO.getContactNumber());
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypt password
        user.setUserType(userDTO.getUserType());

        return userRepository.save(user);
    }
}
