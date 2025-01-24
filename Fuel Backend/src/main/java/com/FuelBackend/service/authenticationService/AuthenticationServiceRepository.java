package com.FuelBackend.service.authenticationService;

import com.FuelBackend.dataTransferObject.request.loginRequestDTO.*;
import org.springframework.http.ResponseEntity;

public interface AuthenticationServiceRepository {

    public String userLogin(UserLoginRequestDTO userLoginRequestDTO);

    public ResponseEntity<?> businessLogin(BusinessGovLoginRequestDTO businessGovLoginRequestDTO);

    public ResponseEntity<?> employeeLogin(EmployeeLoginRequestDTO employeeLoginRequestDTO);

    public ResponseEntity<?> fuelStationLogin(FuelStationLoginRequestDTO fuelStationLoginRequestDTO);
    public boolean resetPasswordWithToken(String token, String newPassword);
    public ResponseEntity<?> administratorLogin(AdministratorLoginRequestDTO administratorLoginRequestDTO);
}
