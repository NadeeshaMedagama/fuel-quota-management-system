package com.FuelBackend.controller;

import com.FuelBackend.dataTransferObject.request.loginRequestDTO.*;
import com.FuelBackend.service.authenticationService.AuthenticationServiceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {


    private final AuthenticationServiceRepository authenticationServiceRepository;

    public AuthenticationController(AuthenticationServiceRepository authenticationServiceRepository) {
        this.authenticationServiceRepository = authenticationServiceRepository;
    }
//
    @PostMapping("/administratorAuth")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> AdministratorLogin( @RequestBody AdministratorLoginRequestDTO administratorLoginRequestDTO
    ){
        return authenticationServiceRepository.administratorLogin(administratorLoginRequestDTO);
    }

    @PostMapping("/userAuth")
    public String userLogin(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
//      log.info("user login controller");
       return authenticationServiceRepository.userLogin(userLoginRequestDTO);
    }

//    @PostMapping("/employeeAuth")
//    public ResponseEntity<?> employeeLogin(@RequestBody EmployeeLoginRequestDTO employeeLoginRequestDTO){
//        return authenticationServiceRepository.employeeLogin(employeeLoginRequestDTO);
//    }

//    @PostMapping("/fuelStationAuth")
//    public ResponseEntity<?> fuelStationLogin(@RequestBody FuelStationLoginRequestDTO fuelStationLoginRequestDTO){
//        return authenticationServiceRepository.fuelStationLogin(fuelStationLoginRequestDTO);
//    }
//
//    @PostMapping("/businessGovAuth")
//    public ResponseEntity<?> businessLogin(@RequestBody BusinessGovLoginRequestDTO businessGovLoginRequestDTO){
//        return authenticationServiceRepository.businessLogin(businessGovLoginRequestDTO);
//    }




        @PostMapping ("/reset-password")
        public String resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
            String token = resetPasswordRequest.getToken();
            String newPassword = resetPasswordRequest.getNewPassword();

            // Validate the token and reset the password
            boolean isPasswordReset = authenticationServiceRepository.resetPasswordWithToken(token, newPassword);

            if (isPasswordReset) {
                return "Password has been reset successfully.";
            } else {
                return "Invalid or expired reset token.";
            }
        }

        static class ResetPasswordRequest {
            private String token;
            private String newPassword;

            // Getters and Setters
            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getNewPassword() {
                return newPassword;
            }

            public void setNewPassword(String newPassword) {
                this.newPassword = newPassword;
            }
        }
    }


