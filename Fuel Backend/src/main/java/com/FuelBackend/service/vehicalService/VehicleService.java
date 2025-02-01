package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.*;
import com.FuelBackend.entity.*;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.*;
import com.FuelBackend.utility.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService implements VehicleServiceRepository {
    private DmtOfficeRepository dmtOfficeRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleClassesRepository vehicleClassesRepository;
    private final UserRepository userRepository;
    private final FuelRepository fuelRepository;
    private final BusinessGovernmentRepository businessGovernmentRepository;

    @Autowired
    public VehicleService(
            VehicleRepository vehicleRepository,
            VehicleClassesRepository vehicleClassesRepository,
            UserRepository userRepository,
            FuelRepository fuelRepository,
            BusinessGovernmentRepository businessGovernmentRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleClassesRepository = vehicleClassesRepository;
        this.userRepository = userRepository;
        this.fuelRepository = fuelRepository;
        this.businessGovernmentRepository = businessGovernmentRepository;
    }

    @Override
    public ResponseEntity<?> createVehicle(VehicleResponseDTO vehicleRequestDTO) {
        User user = userRepository.findById(vehicleRequestDTO.getOwnerId()).orElseThrow(
                () -> new NotFoundException("User ID not found")
        );

        Vehicle vehicle = new Vehicle(
                vehicleRequestDTO.getVehicleNumber(),
                vehicleRequestDTO.getVehicleEngineNo(),
                vehicleRequestDTO.getOwnerId(),
                vehicleRequestDTO.getVehicleType(),
                vehicleRequestDTO.getPassword()
        );

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                savedVehicle.getVehicleNumber(),
                savedVehicle.getVehicleEngineNo(),
                savedVehicle.getOwnerId(),
                savedVehicle.getVehicleType(),
                savedVehicle.getPassword()

        );

        return new ResponseEntity<>(new CustomApiResponse(HttpStatus.CREATED.value(), "Vehicle created successfully"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> createBusinessGovVehicle(VehicleResponseDTO vehicleRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> findVehicleById(int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new NotFoundException("Vehicle not found")
        );

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                vehicle.getVehicleNumber(),
                vehicle.getVehicleEngineNo(),
                vehicle.getOwnerId(),
                vehicle.getVehicleType(),
                vehicle.getPassword()
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateVehicleCurrentFuelCapacity(int vehicleId, Double fuelCapacity) {
        if (fuelCapacity == null || fuelCapacity <= 0) {
            return new ResponseEntity<>("Fuel capacity must be greater than zero.", HttpStatus.BAD_REQUEST);
        }

        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new NotFoundException("Vehicle not found with ID: " + vehicleId)
        );

        vehicle.setCurrentFuelCapacity(fuelCapacity);
        vehicleRepository.save(vehicle);

        return new ResponseEntity<>("Fuel capacity updated successfully for vehicle ID: " + vehicleId, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateVehicle(VehicleResponseDTO vehicleRequestDTO) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteVehicle(int vehicleId) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllVehicle() {
        return null;
    }

    @Override
    public String generateAndSaveQRCode(VehicleResponseDTO vehicleRequestDTO) {
        try {
            if (vehicleRequestDTO.getVehicleNumber() == null || vehicleRequestDTO.getVehicleNumber().isEmpty()) {
                throw new IllegalArgumentException("Vehicle Register ID cannot be null or empty.");
            }

            String data = "Vehicle: " + vehicleRequestDTO.getVehicleNumber();
            byte[] qrCode = QRCodeGenerator.generateQRCode(data, 200, 200);

            Vehicle vehicle = new Vehicle(
                    vehicleRequestDTO.getVehicleNumber(),
                    vehicleRequestDTO.getVehicleEngineNo(),
                    vehicleRequestDTO.getOwnerId(),
                    vehicleRequestDTO.getVehicleType(),
                    vehicleRequestDTO.getPassword()
            );

            vehicle.setQrCode(qrCode);
            vehicleRepository.save(vehicle);

            return "/api/vehicle/qr/" + vehicle.getVehicleId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate QR Code.", e);
        }
    }

    @Override
    public boolean validateVehicleDetails(VehicleResponseDTO vehicleRequestDTO) {

        List<String> validVehicleNumbers = dmtOfficeRepository.findAllVehicleNumbers();

        if(validVehicleNumbers.contains(vehicleRequestDTO.getVehicleNumber())) {
            System.out.println("hi hello");
            return true;

        }
         return false;
        }


@Override
    public Vehicle registerVehicle(VehicleRequestDTO vehicleDTO) {
        Optional<VehicleClasses> vehicleClassOpt = vehicleClassesRepository.findByVehicleClassName(vehicleDTO.getVehicleType());

    System.out.println(vehicleDTO);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setVehicleEngineNo(vehicleDTO.getVehicleEngineNo());
        vehicle.setOwnerId(vehicleDTO.getOwnerId());
        vehicle.setPassword(vehicleDTO.getPassword());
        vehicle.setVehicleType(vehicleDTO.getVehicleType());
    System.out.println(vehicle);
        vehicle.setFuelQuota(vehicleClassOpt.map(VehicleClasses::getMaxFuelCapacityPerWeek).orElse(0.0));

        return vehicleRepository.save(vehicle);
    }
}
