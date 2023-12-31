package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.stereotype.Component;

@Component
public interface NotificationTempFactory {
    public NotificationTemplate createNotification(String type);
}