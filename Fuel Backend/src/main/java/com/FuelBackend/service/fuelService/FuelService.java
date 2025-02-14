package com.FuelBackend.service.fuelService;


import com.FuelBackend.dataTransferObject.request.fuelRequestDTO.FuelRequestDTO;
import com.FuelBackend.dataTransferObject.response.CustomApiResponse;
import com.FuelBackend.dataTransferObject.response.fuelResponseDTO.FuelResponseDTO;
import com.FuelBackend.entity.Fuel;
import com.FuelBackend.exception.NotFoundException;
import com.FuelBackend.repositoryDAO.FuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelService implements FuelServiceRepository{

    private final FuelRepository fuelRepository;

    @Autowired
    public FuelService(FuelRepository fuelRepository){
        this.fuelRepository = fuelRepository;
    }



    @Override
    public ResponseEntity<?> createFuel(FuelRequestDTO fuelRequestDTO) {
        Fuel fuel = new Fuel(fuelRequestDTO.getFuelName(),fuelRequestDTO.getPrice());

        Fuel savedFuel = fuelRepository.save(fuel);
        FuelResponseDTO responseDTO = new FuelResponseDTO(
                savedFuel.getFuelId(),
                savedFuel.getFuelName(),
                savedFuel.getPrice()
        );


        return new ResponseEntity<>(

                    responseDTO
                ,
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<?> findFuelById(Integer fuelId){
        Fuel fuel = fuelRepository.findById(fuelId).orElseThrow(
                () -> new NotFoundException("fuel not found")
        );
        FuelResponseDTO responseDTO = new FuelResponseDTO(
                fuel.getFuelId(),
                fuel.getFuelName(),
                fuel.getPrice()
        );


        return new ResponseEntity<>(

                        responseDTO
                ,
                HttpStatus.OK
        );
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateFuelPrice(Integer fuelId, Double price) {
        Fuel fuel = fuelRepository.findById(fuelId).orElseThrow(
                () -> new NotFoundException("fuel not found")
        );

        fuel.setPrice(price);
        Fuel updateFuel = fuelRepository.save(fuel);

        FuelResponseDTO responseDTO = new FuelResponseDTO(
                updateFuel.getFuelId(),
                updateFuel.getFuelName(),
                updateFuel.getPrice()
        );
        return new ResponseEntity<>(

                        responseDTO,

                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> getAllFuel() {
        List<Fuel> fuels = fuelRepository.findAll();
        List<FuelResponseDTO> responseDTOList = new ArrayList<>();

        fuels.forEach(
                fuel -> {
                    responseDTOList.add(
                            new FuelResponseDTO(
                                    fuel.getFuelId(),
                                    fuel.getFuelName(),
                                    fuel.getPrice()
                            )
                    );
                }
        );
        return new ResponseEntity<>(

                        responseDTOList,

                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<?> DeleteFuelById(Integer fuelId) {

        return new ResponseEntity<>("not implemented",HttpStatus.NOT_IMPLEMENTED);  // temporary not implemented
    }
}
