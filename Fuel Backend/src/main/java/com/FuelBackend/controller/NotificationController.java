package com.FuelBackend.controller;

import com.FuelBackend.service.notificationService.TwilioService;
import com.FuelBackend.service.notificationService.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    private final TwilioService twilioService;

    @Autowired
    public NotificationController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @GetMapping("/send-notification")
    public String sendNotification() {
        String toPhoneNumber = "0716889714";
        String message = "Your fuel quota has been updated.";
        twilioService.sendSms(toPhoneNumber, message);
        return "Notification sent!";
    }


}
