package com.FuelBackend.service.vehicalService;

import com.FuelBackend.dataTransferObject.request.vehicleRequestDTO.VehicleRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.vehicleResponseDTO.VehicleResponseDTO;
import com.FuelBackend.entity.Fuel;
import com.FuelBackend.entity.User;
import com.FuelBackend.entity.Vehicle;
import com.FuelBackend.entity.VehicleClasses;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.FuelRepository;
import com.FuelBackend.repositoryDAO.UserRepository;
import com.FuelBackend.repositoryDAO.VehicleClassesRepository;
import com.FuelBackend.repositoryDAO.VehicleRepository;
import com.FuelBackend.utility.QRCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService implements VehicleServiceRepository{

    private final VehicleRepository vehicleRepository;

    private final VehicleClassesRepository vehicleClassesRepository;

    private final UserRepository userRepository;

    private final FuelRepository fuelRepository;

    @Autowired
    public VehicleService(
            VehicleRepository vehicleRepository,
            VehicleClassesRepository vehicleClassesRepository,
            UserRepository userRepository, FuelRepository fuelRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleClassesRepository = vehicleClassesRepository;
        this.userRepository = userRepository;
        this.fuelRepository = fuelRepository;
    }

    @Override
    public ResponseEntity<?> createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        User user = userRepository.findById(vehicleRequestDTO.getUserId()).orElseThrow(
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
                vehicleRequestDTO.getModel(),
                vehicleRequestDTO.getYearOfManufacture(),
                user,
                null,
                vehicleClass,
                fuel
        );

        Vehicle savedVehicle = vehicleRepository.save(vehicle);

        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                savedVehicle.getVehicleId(),
                savedVehicle.getVehicleRegisterId(),
                savedVehicle.getVehicleEngineNo(),
                savedVehicle.getModel(),
                savedVehicle.getYearOfManufacture(),
                savedVehicle.getCurrentFuelCapacity(),
                savedVehicle.getUser().getUserId(),
                savedVehicle.getVehicleClasses().getVehicleClassId(),
                savedVehicle.getFuel().getFuelId()
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
    public ResponseEntity<?> findVehicleById(int vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(
                () -> new NotFoundException("vehicle not found")
        );
        VehicleResponseDTO responseDTO = new VehicleResponseDTO(
                vehicle.getVehicleId(),
                vehicle.getVehicleRegisterId(),
                vehicle.getVehicleEngineNo(),
                vehicle.getModel(),
                vehicle.getYearOfManufacture(),
                vehicle.getCurrentFuelCapacity(),
                vehicle.getUser().getUserId(),
                vehicle.getVehicleClasses().getVehicleClassId(),
                vehicle.getFuel().getFuelId()
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
                                    vehicle.getVehicleRegisterId(),
                                    vehicle.getVehicleEngineNo(),
                                    vehicle.getModel(),
                                    vehicle.getYearOfManufacture(),
                                    vehicle.getCurrentFuelCapacity(),
                                    vehicle.getUser().getUserId(),
                                    vehicle.getVehicleClasses().getVehicleClassId(),
                                    vehicle.getFuel().getFuelId()
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
        List<String> allRegisterIds=vehicleRepository.findAllVehicleRegisterIds();

        return allRegisterIds.contains(vehicleRequestDTO.getVehicleRegisterId());

    }
@Override
    public String generateAndSaveQRCode(VehicleRequestDTO vehicleRequestDTO){
        try {
            if (vehicleRequestDTO.getVehicleRegisterId() == null || vehicleRequestDTO.getVehicleRegisterId().isEmpty()) {
                throw new IllegalArgumentException("Vehicle Register ID cannot be null or empty.");}
            String data = "Vehicle:ABC123456 " ;

            byte[] qrCode = QRCodeGenerator.generateQRCode(data, 200, 200);


            Vehicle vehicle = new Vehicle();
        vehicle.setVehicleRegisterId(vehicleRequestDTO.getVehicleRegisterId());
            vehicle.setQrCode(qrCode);
            vehicleRepository.save(vehicle);


            return "/api/vehicle/qr/" + vehicle.getVehicleId();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to generate QR Code.", e);
        }
    }



}
