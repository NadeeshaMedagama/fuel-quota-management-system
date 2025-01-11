package com.FuelBackend.dataTransferObject.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
public class ExceptionResponseDTO {
    private boolean status;

    private LocalDateTime date;

    private String message;

    public ExceptionResponseDTO(boolean status, String message) {
        this.status = status;
        this.message = message;
        this.date = LocalDateTime.now();
    }

}
