package com.FuelBackend.service.smsService;

public interface SmsServiceRepository {

    public void sendMessage(String number, String message);



}
