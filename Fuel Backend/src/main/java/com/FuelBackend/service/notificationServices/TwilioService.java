package com.FuelBackend.service.notificationServices;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
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

    // Initialize Twilio using the injected values
    public TwilioService() {
        Twilio.init(accountSid, authToken);
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
