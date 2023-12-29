package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;

public class ShipmentTemplate extends NotificationTemplate{
    public ShipmentTemplate(String subject, String body, Customer customer, Order order) {
        super(subject, body);
    }
    @Override
    public void setBody() {

    }
}
