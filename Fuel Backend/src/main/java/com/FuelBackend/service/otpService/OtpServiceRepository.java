package com.FuelBackend.service.otpService;

public interface OtpServiceRepository {

    public void sendOtp(String mobileNumber);

    public boolean verifyOtp(String mobileNumber, int otp);
}
