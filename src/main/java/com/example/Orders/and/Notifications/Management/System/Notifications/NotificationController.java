package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;

@RestController
@RequestMapping(path = "api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("/all")
    public void getAllNotifications(){
        notificationService.getAllNotifications();
    }
    public void saveNotification(Notification notification){
        notificationService.saveNotification(notification);
    }
    @Scheduled(fixedRate = 5000) // Run every 5 seconds
    public void processNotifications(){
        notificationService.processNotifications();
    }
}
