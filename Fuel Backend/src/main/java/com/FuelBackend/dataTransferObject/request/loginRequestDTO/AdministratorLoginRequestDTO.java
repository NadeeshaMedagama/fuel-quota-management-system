package com.FuelBackend.dataTransferObject.request.loginRequestDTO;

import jakarta.validation.constraints.NotBlank;

public class AdministratorLoginRequestDTO {
    @NotBlank(message = "administrator Email is required")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    public AdministratorLoginRequestDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
