package com.FuelBackend.controller;

import com.FuelBackend.service.notificationServices.NotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationServices.TwilioService twilioService;

@GetMapping("/send-notification")
    public String sendNotification() {
        String toPhoneNumber = "0716889714";
        String message = "Your fuel quota has been updated.";
        twilioService.sendSms(toPhoneNumber, message);
        return "Notification sent!";
    }


}
