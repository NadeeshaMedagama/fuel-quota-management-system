package com.FuelBackend.dataTransferObject.request.loginRequestDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserLoginRequestDTO {

    @NotBlank
    private String contactNumber;

    @NotBlank
    private String password;

    public UserLoginRequestDTO(String contactNumber, String password) {
        this.contactNumber=contactNumber;
        this.password = password;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
