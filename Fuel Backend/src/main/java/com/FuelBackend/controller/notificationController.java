import com.example.notification.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private TwilioService twilioService;

    @RequestMapping(value = "/send-notification", method = RequestMethod.GET)
    public String sendNotification() {
        String toPhoneNumber = "+1234567890";  // Replace with actual recipient phone number
        String message = "Your fuel quota has been updated.";
        twilioService.sendSms(toPhoneNumber, message);
        return "Notification sent!";
    }
}