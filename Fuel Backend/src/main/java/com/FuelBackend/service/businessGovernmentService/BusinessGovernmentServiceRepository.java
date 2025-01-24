package com.FuelBackend.service.businessGovernmentService;

import com.FuelBackend.dataTransferObject.request.businessGovernmentRequestDTO.BusinessGovernmentRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BusinessGovernmentServiceRepository {

    public ResponseEntity<?> createBusinessGovernment(BusinessGovernmentRequestDTO businessGovernmentRequestDTO);

    public ResponseEntity<?> verifyBusinessGovernmentMobile(int businessGovernmentId, Integer otp);

    public ResponseEntity<?> businessGovernmentFindById(int businessGovernmentId);

    public ResponseEntity<?> businessGovernmentGetAll();
}
