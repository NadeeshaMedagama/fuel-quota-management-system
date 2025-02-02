package com.FuelBackend.controller;

import com.FuelBackend.entity.Notification;
import com.FuelBackend.service.notificationService.NotificationService;
import com.FuelBackend.service.notificationService.TwilioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NotificationController {

    private final NotificationService notificationService;
    private final TwilioServices twilioService;

    @Autowired
    public NotificationController(NotificationService notificationService, TwilioServices twilioServices) {
        this.notificationService = notificationService;
        this.twilioService = twilioServices;
    }


    @GetMapping("/send-notification")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }


    @DeleteMapping("/notifications/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
        boolean isDeleted = notificationService.deleteNotification(id);
        if (isDeleted) {
            return ResponseEntity.ok("Notification deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Notification not found.");
        }
    }


    @PostMapping("/send-sms")
    public ResponseEntity<String> sendSms(@RequestParam String toPhoneNumber, @RequestParam String message) {
        twilioService.sendSms(toPhoneNumber, message);
        return ResponseEntity.ok("SMS sent successfully!");
    }
}
