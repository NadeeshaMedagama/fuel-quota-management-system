package com.FuelBackend.service.administratorService;

import com.FuelBackend.dataTransferObject.request.administratorRequestDTO.AdministratorRequestDTO;
import org.springframework.http.ResponseEntity;

public interface AdministratorServiceRepository {

    public ResponseEntity<?> createAdministrator(AdministratorRequestDTO administratorRequestDTO);

    public ResponseEntity<?> updateAdministrator(Integer administratorId,AdministratorRequestDTO administratorRequestDTO);

    public ResponseEntity<?> deleteAdministrator(Integer administratorId);

    public ResponseEntity<?> administratorFindById(Integer administratorId);

    public ResponseEntity<?> getAllAdministrators();
}
