package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.VehicleResponseDTO;
import com.FuelBackend.entity.User;
import com.FuelBackend.entity.Vehicle;
import com.FuelBackend.entity.VehicleClasses;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.*;
import com.FuelBackend.service.vehicalService.VehicleServiceRepository;
import com.FuelBackend.utility.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements VehicleServiceRepository {
    private final DmtOfficeRepository dmtOfficeRepository;
    private final VehicleRepository vehicleRepository;
    private final VehicleClassesRepository vehicleClassesRepository;
    private final UserRepository userRepository;
    private final FuelRepository fuelRepository;
    private final BusinessGovernmentRepository businessGovernmentRepository;

    @Autowired
    public VehicleService(DmtOfficeRepository dmtOfficeRepository, VehicleRepository vehicleRepository, VehicleClassesRepository vehicleClassesRepository, UserRepository userRepository, FuelRepository fuelRepository, BusinessGovernmentRepository businessGovernmentRepository) {
        this.dmtOfficeRepository = dmtOfficeRepository;
        this.vehicleRepository = vehicleRepository;
        this.vehicleClassesRepository = vehicleClassesRepository;
        this.userRepository = userRepository;
        this.fuelRepository = fuelRepository;
        this.businessGovernmentRepository = businessGovernmentRepository;
    }

    @Override
    public ResponseEntity<VehicleResponseDTO> createVehicle(VehicleRequestDTO request) {
        User user = userRepository.findById(request.getOwnerId()).orElseThrow(
                () -> new NotFoundException("User ID not found")
        );

        Vehicle vehicle = new Vehicle(
                request.getVehicleNumber(),
                request.getVehicleEngineNo(),
                request.getOwnerId(),
                request.getVehicleType(),
                request.getPassword()
        );

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                savedVehicle.getVehicleNumber(),
                savedVehicle.getVehicleEngineNo(),
                savedVehicle.getOwnerId(),
                savedVehicle.getVehicleType(),
                savedVehicle.getPassword()
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> createBusinessGovVehicle(VehicleRequestDTO vehicleRequestDTO) {
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
    public ResponseEntity<?> updateVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleRequestDTO.getOwnerId()); // Fix this to vehicleId

        if (optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setVehicleNumber(vehicleRequestDTO.getVehicleNumber());
            vehicle.setVehicleType(vehicleRequestDTO.getVehicleType());
            vehicle.setVehicleEngineNo(vehicleRequestDTO.getVehicleEngineNo());
            vehicle.setPassword(vehicleRequestDTO.getPassword());

            vehicleRepository.save(vehicle);
            return ResponseEntity.ok("Vehicle updated successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
    }

    @Override
    public ResponseEntity<?> deleteVehicle(int vehicleId) {
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

        if (optionalVehicle.isPresent()) {
            vehicleRepository.deleteById(vehicleId);
            return ResponseEntity.ok("Vehicle deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
    }

    @Override
    public ResponseEntity<?> getAllVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return ResponseEntity.ok(vehicles);
    }

    @Override
    public String generateAndSaveQRCode(VehicleRequestDTO vehicleRequestDTO) {
        System.out.println(vehicleRequestDTO.getVehicleNumber()+vehicleRequestDTO.getVehicleEngineNo()+vehicleRequestDTO.getOwnerId());
        System.out.println("hi  ");
        try {
            System.out.println(vehicleRequestDTO);
            if (vehicleRequestDTO.getVehicleNumber() == null || vehicleRequestDTO.getVehicleNumber().isEmpty()) {
                throw new IllegalArgumentException("Vehicle Register ID cannot be null or empty.");
            }
            System.out.println("thanoo");
            String data = "Vehicle: " + vehicleRequestDTO.getVehicleNumber();
            System.out.println("Diwa");
            byte[] qrCode = QRCodeGenerator.generateQRCode(data, 200, 200);
            System.out.println("iiilik");
            Vehicle vehicle = new Vehicle(
                    vehicleRequestDTO.getVehicleNumber(),
                    vehicleRequestDTO.getVehicleEngineNo(),
                    vehicleRequestDTO.getOwnerId(),
                    vehicleRequestDTO.getVehicleType(),
                    vehicleRequestDTO.getPassword()
            );
           vehicle.setVehicleNumber(vehicleRequestDTO.getVehicleNumber());
           vehicle.setVehicleEngineNo(vehicleRequestDTO.getVehicleEngineNo());
           vehicle.setOwnerId(vehicleRequestDTO.getOwnerId());
           vehicle.setVehicleType(vehicleRequestDTO.getVehicleType());
           vehicle.setPassword(vehicleRequestDTO.getPassword());
            vehicle.setQrCode(qrCode);
            vehicleRepository.save(vehicle);
            System.out.println("jlj");
            return "/api/vehicle/qr/" + vehicle.getVehicleId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate QR Code.", e);
        }
    }

    @Override
    public boolean validateVehicleDetails(VehicleRequestDTO vehicleRequestDTO) {
        List<String> validVehicleNumbers = dmtOfficeRepository.findAllVehicleNumbers();

        if(validVehicleNumbers.contains(vehicleRequestDTO.getVehicleNumber())) {
            return true;
        }
        return false;
    }

    @Override
    public Vehicle registerVehicle(VehicleRequestDTO vehicleDTO) {
        Optional<VehicleClasses> vehicleClassOpt = vehicleClassesRepository.findByVehicleClassName(vehicleDTO.getVehicleType());

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleDTO.getVehicleNumber());
        vehicle.setVehicleEngineNo(vehicleDTO.getVehicleEngineNo());
        vehicle.setOwnerId(vehicleDTO.getOwnerId());
        vehicle.setPassword(vehicleDTO.getPassword());
        vehicle.setVehicleType(vehicleDTO.getVehicleType());
        vehicle.setFuelQuota(vehicleClassOpt.map(VehicleClasses::getMaxFuelCapacityPerWeek).orElse(0.0));

        // Generate and save QR code after the vehicle is registered
        String qrCodeUrl = generateAndSaveQRCode(vehicleDTO);
        return vehicleRepository.save(vehicle);
    }
}
