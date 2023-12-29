package com.example.Orders.and.Notifications.Management.System.Notifications;

public interface NotificationFactory {
    public NotificationTemplate createNotification(String type);
}
