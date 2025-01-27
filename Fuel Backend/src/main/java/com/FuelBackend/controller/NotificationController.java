package com.FuelBackend.controller;

import com.FuelBackend.service.notificationServices.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final TwilioService twilioService;

    @Autowired
    public NotificationController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @GetMapping("/send-notification")
    public String sendNotification() {
        String toPhoneNumber = "+94726406224";
        String message = "Your fuel quota has been updated.";
        twilioService.sendSms(toPhoneNumber, message);
        return "SMS sent successfully!";
    }


}
