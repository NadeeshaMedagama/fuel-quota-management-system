package com.FuelBackend.service.userService;

import com.FuelBackend.dataTransferObject.request.userRequestDTO.UserRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.userResponseDTO.UserResponseDTO;
import com.FuelBackend.entity.User;
import com.FuelBackend.repositoryDAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserServiceRepository{

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public ResponseEntity<?> createUser(UserRequestDTO userRequestDTO) {
        User user = new User(
                userRequestDTO.getF_name(),
                userRequestDTO.getL_name(),
                userRequestDTO.getEmail(),
                userRequestDTO.getPassword(),
                userRequestDTO.getMobile()
        );

        User savedUser = userRepository.save(user);
        UserResponseDTO responseData = new UserResponseDTO(
                savedUser.getUserId(),
                savedUser.getF_name(),
                savedUser.getL_name(),
                savedUser.getEmail(),
                savedUser.getMobile()
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
        user.setF_name(userRequestDTO.getF_name());
        user.setL_name(userRequestDTO.getL_name());
        user.setEmail(userRequestDTO.getEmail());
        user.setMobile(userRequestDTO.getMobile());

        User updatedUser = userRepository.save(user);
        UserResponseDTO responseData = new UserResponseDTO(
                updatedUser.getUserId(),
                updatedUser.getF_name(),
                updatedUser.getL_name(),
                updatedUser.getEmail(),
                updatedUser.getMobile()
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
                user.getUserId(),
                user.getF_name(),
                user.getL_name(),
                user.getEmail(),
                user.getMobile()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "user founded"
                ),
                HttpStatus.OK
        );
    }
}
