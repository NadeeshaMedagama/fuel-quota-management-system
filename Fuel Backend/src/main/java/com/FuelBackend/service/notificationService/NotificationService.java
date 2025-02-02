package com.FuelBackend.service.notificationService;


import com.FuelBackend.entity.Notification;
import com.FuelBackend.repositoryDAO.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Fetch all notifications
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    // Delete a notification by ID
    public boolean deleteNotification(Long id) {
        Optional<Notification> notification = notificationRepository.findById(id);
        if (notification.isPresent()) {
            notificationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

