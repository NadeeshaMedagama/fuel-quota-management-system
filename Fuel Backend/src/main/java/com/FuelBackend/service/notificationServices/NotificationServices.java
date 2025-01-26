package com.FuelBackend.service.notificationServices;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationServices {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String fromPhoneNumber;



    public static class TwilioService {

        private final String accountSid;
        private final String authToken;
        private final String fromPhoneNumber;

        public TwilioService(String accountSid, String authToken, String fromPhoneNumber) {
            this.accountSid = accountSid;
            this.authToken = authToken;
            this.fromPhoneNumber = fromPhoneNumber;


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
}