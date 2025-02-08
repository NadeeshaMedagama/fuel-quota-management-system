package com.FuelBackend.service.smsService;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;

public class SmsService implements SmsServiceRepository{

    @Value("${twilio.fromPhoneNumber}")
    private String twilioNumber;

    @Override
    public void sendMessage(String number, String message) {

        Message.creator(new PhoneNumber(number), new PhoneNumber(twilioNumber), message).create();

    }
}
