import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
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

    public TwilioService() {
        // Initialize Twilio SDK with Account SID and Auth Token
        Twilio.init(accountSid, authToken);
    }

    public void sendSms(String toPhoneNumber, String message) {
        try {
            // Send SMS
            com.twilio.rest.api.v2010.account.Message.creator(
                    new PhoneNumber(toPhoneNumber),  // Recipient phone number
                    new PhoneNumber(fromPhoneNumber), // Twilio phone number
                    message                          // Message content
            ).create();
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            System.err.println("Error sending message: " + e.getMessage());
        }
    }
}