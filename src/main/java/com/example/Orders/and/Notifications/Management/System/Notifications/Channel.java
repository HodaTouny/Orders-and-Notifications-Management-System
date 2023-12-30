package com.example.Orders.and.Notifications.Management.System.Notifications;

import com.example.Orders.and.Notifications.Management.System.Orders.Order;

public interface Channel {
    public void send(Notification notification);

}
