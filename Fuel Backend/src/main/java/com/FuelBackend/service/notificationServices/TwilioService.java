package com.FuelBackend.service.notificationServices;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class TwilioService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromPhoneNumber;

    // Method to initialize Twilio after properties are injected
    @PostConstruct
    public void init() {
        if (accountSid != null && authToken != null) {
            Twilio.init(accountSid, authToken);
            System.out.println("Twilio initialized successfully.");
        } else {
            System.err.println("Twilio credentials are missing.");
        }
    }

    public void sendSms(String toPhoneNumber, String message) {
        try {
            Message twilioMessage = Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(fromPhoneNumber),
                    message
            ).create();

            System.out.println("Message sent successfully! SID: " + twilioMessage.getSid());
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}
