package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.stereotype.Component;

@Component
public interface NotificationFactory {
    public NotificationTemplate createNotification(String type);
}