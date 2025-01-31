package com.FuelBackend.dataTransferObject.request.userRequestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "Full Name is required.")
    private String fullName;

    private String address;

    @NotBlank(message = "Contact Number is required.")
    @Pattern(regexp = "\\d{10}", message = "Contact Number must be 10 digits.")
    private String contactNumber;

    @NotBlank(message = "Username is required.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @NotBlank(message = "User Type is required.")
    private String userType;

    public UserRequestDTO(String fullName, String address, String contactNumber, String username, String password, String userType) {
        this.fullName = fullName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}