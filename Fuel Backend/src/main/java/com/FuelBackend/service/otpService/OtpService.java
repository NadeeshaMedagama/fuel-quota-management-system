package com.FuelBackend.service.otpService;

import com.FuelBackend.service.smsService.SmsServiceRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OtpService implements OtpServiceRepository{

    private final SmsServiceRepository smsServiceRepository;

    private final Map<String, Integer> temperaryOtpStorage = new HashMap<>();

    public OtpService(SmsServiceRepository smsServiceRepository) {
        this.smsServiceRepository = smsServiceRepository;
    }

    @Override
    public void sendOtp(String mobileNumber) {

        Random random = new Random();

        int otp = 100000 + random.nextInt(900000);

        temperaryOtpStorage.put(mobileNumber, otp);

    }

    @Override
    public boolean verifyOtp(String mobileNumber, int otp) {

        if (temperaryOtpStorage.containsKey(mobileNumber) && temperaryOtpStorage.get(mobileNumber).equals(otp)) {

            temperaryOtpStorage.remove(mobileNumber);
            return true;

        } else {

            return false;

        }
    }
}
