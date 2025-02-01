package com.FuelBackend.service.notificationService;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromPhoneNumber;

    public void TwilioService() {

        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String toPhoneNumber, String message) {
        try {
            Twilio.init(accountSid, authToken);
            com.twilio.rest.api.v2010.account.Message.creator(
                    new PhoneNumber(toPhoneNumber),
                    new PhoneNumber(fromPhoneNumber),
                    message
            ).create();
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}