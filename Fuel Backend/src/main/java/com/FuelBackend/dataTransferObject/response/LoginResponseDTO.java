package com.FuelBackend.dataTransferObject.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDTO {

    private Integer statusCode;

    private String message;

    private String accessToken;

    private Object data;

    public LoginResponseDTO(Integer statusCode, String message, String accessToken, Object data) {
        this.statusCode = statusCode;
        this.message = message;
        this.accessToken = accessToken;
        this.data = data;
    }

}
