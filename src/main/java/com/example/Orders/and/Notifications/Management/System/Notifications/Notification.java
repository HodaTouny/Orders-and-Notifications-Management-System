package com.example.Orders.and.Notifications.Management.System.Notifications;

import com.example.Orders.and.Notifications.Management.System.Orders.Order;
import com.example.Orders.and.Notifications.Management.System.Orders.SimpleOrder;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

public class Notification {
    SimpleOrder order;
    Channel channel;
    NotificationTemplate notificationTemplate;

    public Notification(SimpleOrder order, Channel channel, NotificationTemplate notificationTemplate) {
        this.order = order;
        this.channel = channel;
        this.notificationTemplate = notificationTemplate;
        notificationTemplate.setContent(order);
    }

    public void setOrder(SimpleOrder order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
