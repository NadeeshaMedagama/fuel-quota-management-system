package com.FuelBackend.dataTransferObject.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomApiResponse {
    // Getters and setters
    private int statusCode;
    private String message;
    private Object data;

    public CustomApiResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

}
