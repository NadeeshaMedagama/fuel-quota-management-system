package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.userRequestDTO.UserRequestDTO;
import com.FuelBackend.entity.User;
import com.FuelBackend.service.userService.UserServiceRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserServiceRepository userServiceRepository;

    @Autowired
    public UserController(UserServiceRepository userServiceRepository){
        this.userServiceRepository = userServiceRepository;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        return userServiceRepository.createUser(userRequestDTO);
    }

    @PutMapping("/{userId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> updateUser(@RequestBody UserRequestDTO userRequestDTO, @PathVariable Integer userId){
        return userServiceRepository.updateUser(userRequestDTO,userId);
    }

    @GetMapping("/{userId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> findUserById(@PathVariable Integer userId){
        return userServiceRepository.findUserByID(userId);
    }

    @DeleteMapping("/{userId}")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId){
        return userServiceRepository.deleteUser(userId);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserRequestDTO userDTO) {
        try {
            User newUser = userServiceRepository.registerUser(userDTO);
            return ResponseEntity.ok("User registered successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
