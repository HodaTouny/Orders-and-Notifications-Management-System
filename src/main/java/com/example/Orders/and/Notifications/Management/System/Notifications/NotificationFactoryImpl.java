package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.stereotype.Component;

@Component
public class NotificationFactoryImpl implements NotificationFactory {
    @Override
    public NotificationTemplate createNotification(String subject) {
        if (subject.equals("order")) {
            return new OrderTemplate();
        }
        if (subject.equals("shipment")) {
            return new ShipmentTemplate();
        }
        return null;
    }
}