package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public void saveNotification(Notification notification){
        notificationRepository.saveNotification(notification);
    }
    public void getAllNotifications(){
        notificationRepository.getAllNotifications();
    }
}
