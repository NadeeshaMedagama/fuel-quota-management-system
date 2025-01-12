package com.FuelBackend.exception;

public class JwtValidationException extends RuntimeException{
    public JwtValidationException(String message){
        super(message);
    }
}
