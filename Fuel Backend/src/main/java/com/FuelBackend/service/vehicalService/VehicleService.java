package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.VehicleResponseDTO;
import com.FuelBackend.entity.*;
import com.FuelBackend.enums.OwnerType;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.FuelRepository;
import com.FuelBackend.repositoryDAO.UserRepository;
import com.FuelBackend.repositoryDAO.VehicleClassesRepository;
import com.FuelBackend.repositoryDAO.VehicleRepository;
import com.FuelBackend.utility.QRCodeGenerator;
import com.FuelBackend.repositoryDAO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements VehicleServiceRepository{

    private final VehicleRepository vehicleRepository;

    private final VehicleClassesRepository vehicleClassesRepository;

    private final UserRepository userRepository;

    private final FuelRepository fuelRepository;

    private final BusinessGovernmentRepository businessGovernmentRepository;

    @Autowired
    public VehicleService(
            VehicleRepository vehicleRepository,
            VehicleClassesRepository vehicleClassesRepository,
            UserRepository userRepository, FuelRepository fuelRepository, BusinessGovernmentRepository businessGovernmentRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleClassesRepository = vehicleClassesRepository;
        this.userRepository = userRepository;
        this.fuelRepository = fuelRepository;
        this.businessGovernmentRepository = businessGovernmentRepository;
    }

    @Override
    public ResponseEntity<?> createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        User user = userRepository.findById(vehicleRequestDTO.getOwnerId()).orElseThrow(
                () -> new NotFoundException("userId not found")
        );
        VehicleClasses vehicleClass = vehicleClassesRepository.findById(vehicleRequestDTO.getVehicleClassId())
                .orElseThrow(
                        () -> new NotFoundException("vehicleClassId not found")
                );
        Fuel fuel = fuelRepository.findById(vehicleRequestDTO.getFuelId()).orElseThrow(
                () -> new NotFoundException("fuel id is not found")
        );
        Vehicle vehicle = new Vehicle(
                vehicleRequestDTO.getVehicleRegisterId(),
                vehicleRequestDTO.getVehicleEngineNo(),
                OwnerType.User,
                vehicleRequestDTO.getOwnerId(),
                vehicleClass,
                fuel
        );

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                savedVehicle.getVehicleId(),
                savedVehicle.getVehicleNumber(),
                savedVehicle.getVehicleEngineNo(),
                savedVehicle.getOwnerId(),
                savedVehicle.getVehicleClass().getVehicleClassName(),
                savedVehicle.getFuelQuota()
        );
        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.CREATED.value(),
                        "vehicle created successfully"

                ),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<?> createBusinessGovVehicle(VehicleRequestDTO vehicleRequestDTO) {
        // check the business is already exists
        BusinessGovernment gov = businessGovernmentRepository.findById(vehicleRequestDTO.getOwnerId())
                .orElseThrow(
                        () -> new NotFoundException("businessGov not registered")
                );
        VehicleClasses vehicleClass = vehicleClassesRepository.findById(vehicleRequestDTO.getVehicleClassId())
                .orElseThrow(
                        () -> new NotFoundException("vehicleClassId not found")
                );
        Fuel fuel = fuelRepository.findById(vehicleRequestDTO.getFuelId()).orElseThrow(
                () -> new NotFoundException("fuel id is not found")
        );

        Vehicle vehicle = new Vehicle(
                vehicleRequestDTO.getVehicleRegisterId(),
                vehicleRequestDTO.getVehicleEngineNo(),
                OwnerType.User,
                vehicleRequestDTO.getOwnerId(),
                vehicleClass,
                fuel);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        return new ResponseEntity<>(
                new CustomApiResponse(
                        HttpStatus.OK.value(),
                        "businessGov vehicle created successfully"
                ),
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> findVehicleById(int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new NotFoundException("vehicle not found")
        );
        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                vehicle.getVehicleId(),
                vehicle.getVehicleNumber(),
                vehicle.getVehicleEngineNo(),
                vehicle.getOwnerId(),
                vehicle.getVehicleClass().getVehicleClassName(),
                vehicle.getFuelQuota()
        );
        return new ResponseEntity<>(

                        responseDTO
                ,
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> updateVehicleCurrentFuelCapacity(int vehicleId, Double fuelCapacity) {
        try {
            // Validate fuel capacity
            if (fuelCapacity == null || fuelCapacity <= 0) {
                return new ResponseEntity<>("Fuel capacity must be greater than zero.", HttpStatus.BAD_REQUEST);
            }

            // Find the vehicle by ID
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
            if (optionalVehicle.isEmpty()) {
                return new ResponseEntity<>("Vehicle not found with ID: " + vehicleId, HttpStatus.NOT_FOUND);
            }

            // Update fuel capacity
            Vehicle vehicle = optionalVehicle.get();
            vehicle.setCurrentFuelCapacity(fuelCapacity);
            vehicleRepository.save(vehicle);

            return new ResponseEntity<>("Fuel capacity updated successfully for vehicle ID: " + vehicleId, HttpStatus.OK);
        } catch (Exception e) {
            // Handle unexpected errors
            return new ResponseEntity<>("An error occurred while updating fuel capacity: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public ResponseEntity<?> getAllVehicle() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<VehicleResponseDTO> responseList = new ArrayList<>();

        vehicles.forEach(
                vehicle -> {
                    responseList.add(
                            new VehicleResponseDTO(
                                    vehicle.getVehicleId(),
                                    vehicle.getVehicleNumber(),
                                    vehicle.getVehicleEngineNo(),

                                    vehicle.getOwnerId(),
                                    vehicle.getVehicleClass().getVehicleClassName(),
                                    vehicle.getFuelQuota()
                            )
                    );
                }
        );
        return new ResponseEntity<>(

                        responseList,

                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> updateVehicle(VehicleRequestDTO vehicleRequestDTO) {

        return new ResponseEntity<>("not implemented", HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> deleteVehicle(int vehicleId) {
        try {

            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
            if (optionalVehicle.isEmpty()) {
                return new ResponseEntity<>("Vehicle not found with ID: " + vehicleId, HttpStatus.NOT_FOUND);
            }

         
            vehicleRepository.deleteById(vehicleId);
            return new ResponseEntity<>("Vehicle deleted successfully with ID: " + vehicleId, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>("An error occurred while deleting the vehicle: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public  boolean validateVehicleDetails(VehicleRequestDTO vehicleRequestDTO){
        List<String> allRegisterIds=vehicleRepository.findAllVehicleNumber();

        return allRegisterIds.contains(vehicleRequestDTO.getVehicleRegisterId());

    }
@Override
    public String generateAndSaveQRCode(VehicleRequestDTO vehicleRequestDTO){
        try {
            if (vehicleRequestDTO.getVehicleRegisterId() == null || vehicleRequestDTO.getVehicleRegisterId().isEmpty()) {
                throw new IllegalArgumentException("Vehicle Register ID cannot be null or empty.");}
            String data = "Vehicle:ABC123456 " ;

            byte[] qrCode = QRCodeGenerator.generateQRCode(data, 200, 200);


            Vehicle vehicle = new Vehicle(
                    vehicleRequestDTO.getVehicleRegisterId(),
                    vehicleRequestDTO.getVehicleEngineNo(),
                    vehicleRequestDTO.getOwnerId(),
                 vehicleRequestDTO.getFuelId(),
                 vehicleRequestDTO.getVehicleClassId()

                    );

            vehicle.setVehicleNumber(vehicleRequestDTO.getVehicleRegisterId());
            vehicle.setQrCode(qrCode);
            vehicleRepository.save(vehicle);


            return "/api/vehicle/qr/" + vehicle.getVehicleId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate QR Code.", e);
        }
    }



}
