package com.FuelBackend.service.authenticationService;

import com.FuelBackend.dataTransferObject.request.loginRequestDTO.*;
import com.FuelBackend.dataTransferObject.response.LoginResponseDTO;
import com.FuelBackend.dataTransferObject.response.administratorResponseDTO.AdministratorResponseDTO;
import com.FuelBackend.dataTransferObject.response.businessGovernmentResponseDTO.BusinessGovernmentResponseDTO;
import com.FuelBackend.dataTransferObject.response.employeeResponseDTO.EmployeeResponseDTO;
import com.FuelBackend.dataTransferObject.response.fuelStationResponseDTO.FuelStationResponseDTO;
import com.FuelBackend.entity.*;
import com.FuelBackend.exception.UnauthorizedAccessException;
import com.FuelBackend.repositoryDAO.*;
import com.FuelBackend.utility.JwtUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService implements AuthenticationServiceRepository{

    private final UserRepository userRepository;

    private final EmployeeRepository employeeRepository;

    private final BusinessGovernmentRepository businessGovernmentRepository;

    private final FuelStationRepository fuelStationRepository;

    private final JwtUtility jwtUtility;

    private final AuthenticationManager authenticationManager;

    private final AdministratorRepository administratorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthenticationService(UserRepository userRepository, EmployeeRepository employeeRepository, BusinessGovernmentRepository businessGovernmentRepository, FuelStationRepository fuelStationRepository, JwtUtility jwtUtility, AuthenticationManager authenticationManager, AdministratorRepository administratorRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.businessGovernmentRepository = businessGovernmentRepository;
        this.fuelStationRepository = fuelStationRepository;
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.administratorRepository = administratorRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String userLogin(UserLoginRequestDTO userLoginRequestDTO) {

        User user = userRepository.findByContactNumber(userLoginRequestDTO.getContactNumber())
                .orElseThrow(() -> new UnauthorizedAccessException("Username or password incorrect"));

        if (user.getContactNumber().equals(userLoginRequestDTO.getContactNumber()) && passwordEncoder.matches(userLoginRequestDTO.getPassword(), user.getPassword()))
         {
            System.out.println("hi");
            String token = jwtUtility.generateToken(user.getContactNumber(),user.getPassword(),user.getUserType());
            System.out.println("User logged in with token: " + token);
            return token;
        }
        else {

            throw new UnauthorizedAccessException("Username or password incorrect");
        }
    }

//
//    @Override
//    public ResponseEntity<?> employeeLogin(EmployeeLoginRequestDTO employeeLoginRequestDTO) {
//        Employee employee = (Employee) employeeRepository.findByEmployeeUsername(employeeLoginRequestDTO.getUsername())
//                .orElseThrow(
//                        () -> new UnauthorizedAccessException("username or password incorrect")
//                );
//        String token;
//        if (
//                employee != null &&
//                        employee.getEmployeeStatus() &&
//                            employee.getPassword().equals(employeeLoginRequestDTO.getPassword())
//        ){
//
//            token = jwtUtility.generateToken(employee.getEmployeeUsername(),employee.getPassword(),employee.);
//
//        }else{
//            throw new UnauthorizedAccessException("username or password incorrect");
//        }
//        return new ResponseEntity<>(
//                new LoginResponseDTO(
//                        HttpStatus.OK.value(),
//                        "employee login successfully",
//                        token,
//                        new EmployeeResponseDTO(
//                                employee.getEmployeeId(),
//                                employee.getEmployeeUsername(),
//                                employee.getEmployeeEmail(),
//                                employee.getFuelStation().getFuelStationId(),
//                                employee.getEmployeeStatus()
//                        )
//                ),
//                HttpStatus.OK
//        );
//    }
//
//    @Override
//    public ResponseEntity<?> fuelStationLogin(FuelStationLoginRequestDTO fuelStationLoginRequestDTO) {
//        FuelStation fuelStation = (FuelStation) fuelStationRepository.findByLicenseNumber(
//                fuelStationLoginRequestDTO.getFuelStationRegisterId()
//        ).orElseThrow(
//                () -> new UnauthorizedAccessException("username or password incorrect")
//        );
//        String token;
//        if (
//                fuelStation != null &&
//                        fuelStation.getPassword().equals(fuelStationLoginRequestDTO.getPassword())
//        ){
//
//            token = jwtUtility.generateToken(fuelStation.getLicenseNumber(),fuelStation.getPassword());
//        }else{
//            throw new UnauthorizedAccessException("username or password incorrect");
//        }
//        return new ResponseEntity<>(
//                new LoginResponseDTO(
//                        HttpStatus.OK.value(),
//                        "fuel station login successfully",
//                        token,
//                        new FuelStationResponseDTO(
//                                fuelStation.getFuelStationId(),
//                                fuelStation.getLicenseNumber(),
//                                fuelStation.getOwnerName(),
//                                fuelStation.getEmail()
//                        )
//                ),
//                HttpStatus.OK
//        );
//    }
//
//    @Override
//    public ResponseEntity<?> businessLogin(BusinessGovLoginRequestDTO businessGovLoginRequestDTO) {
//        BusinessGovernment businessGovernment = (BusinessGovernment) businessGovernmentRepository.findByBusinessGovernmentRegNo(
//                businessGovLoginRequestDTO.getBusinessGovernmentRegNo()
//        ).orElseThrow(
//                () -> new UnauthorizedAccessException("username or password incorrect")
//        );
//        String token;
//        if(
//                businessGovernment != null &&
//                        businessGovernment.getMobileIsVerify() &&
//                            businessGovernment.getPassword().equals(businessGovLoginRequestDTO.getPassword())
//        ){
//
//            token = jwtUtility.generateToken(businessGovernment.getBusinessGovernmentRegNo(),businessGovernment.getPassword());
//        }else{
//            throw new UnauthorizedAccessException("username or password incorrect");
//        }
//        return new ResponseEntity<>(
//                new LoginResponseDTO(
//                        HttpStatus.OK.value(),
//                        "businessGov login successfully",
//                        token,
//                        new BusinessGovernmentResponseDTO(
//                                businessGovernment.getBusinessGovernmentId(),
//                                businessGovernment.getBusinessGovernmentRegNo(),
//                                businessGovernment.getEmail(),
//                                businessGovernment.getMobile(),
//                                businessGovernment.getMobileIsVerify()
//                        )
//                ),
//                HttpStatus.OK
//        );
//    }
//
    @Override
    public ResponseEntity<?> administratorLogin(AdministratorLoginRequestDTO administratorLoginRequestDTO) {
        System.out.println("hi"+administratorLoginRequestDTO.getEmail()+administratorLoginRequestDTO.getPassword());
        Administrator administrator = administratorRepository.findByAdministratorEmail(
                administratorLoginRequestDTO.getEmail()
        ).orElseThrow(
                () -> new UnauthorizedAccessException("username or password incorrect")
        );
        String token;
        if (administrator != null &&
                passwordEncoder.matches(administratorLoginRequestDTO.getPassword(), administrator.getPassword()))
            {

            token = jwtUtility.generateToken(administrator.getAdministratorUsername(),administrator.getAdministratorEmail(),administrator.getPassword());
        }else{
            throw new UnauthorizedAccessException("username or password incorrect");
        }
        return new ResponseEntity<>(
                new LoginResponseDTO(
                        HttpStatus.OK.value(),
                        "administrator login successfully",
                        token,
                        new AdministratorResponseDTO(
                                administrator.getAdministratorId(),
                                administrator.getAdministratorUsername(),
                                administrator.getAdministratorEmail()
                        )
                ),
                HttpStatus.OK
        );
    }
    private Map<String, String> userDatabase = new HashMap<>(); // Simulating a database with user emails
    private Map<String, String> resetTokens = new HashMap<>(); // Store tokens temporarily
    public void saveResetToken(String email, String token) {
        resetTokens.put(token, email);
    }

    public boolean resetPasswordWithToken(String token, String newPassword) {
        String email = resetTokens.get(token);

        if (email != null) {
            // Update password (simplified)
            userDatabase.put(email, newPassword);
            resetTokens.remove(token); // Remove token after it's used
            return true;
        }
        return false;
    }
}


