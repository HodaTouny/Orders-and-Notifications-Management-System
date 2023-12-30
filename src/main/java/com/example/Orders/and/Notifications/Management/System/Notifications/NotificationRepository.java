package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Queue;

@Repository
public class NotificationRepository {
    Queue<Notification>Notifications;
    public void saveNotification(Notification message){
        Notifications.add(message);
    }
    public Queue<Notification> getAllNotifications() {
        return Notifications;
    }
}
