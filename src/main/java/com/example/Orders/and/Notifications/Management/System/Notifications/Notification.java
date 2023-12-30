package com.example.Orders.and.Notifications.Management.System.Notifications;

import com.example.Orders.and.Notifications.Management.System.Orders.Order;
import com.example.Orders.and.Notifications.Management.System.Orders.SimpleOrder;
import com.example.Orders.and.Notifications.Management.System.Users.Customer;

import java.util.List;

public class Notification {
    private SimpleOrder order;
    //private List<Channel> channel;
    private NotificationTemplate notificationTemplate;
//    public List<Channel> getChannels() {
//        return channel;
//    }


    public Notification(SimpleOrder order , NotificationTemplate notificationTemplate) {
        this.order = order;
        //this.channel = Channel;
        this.notificationTemplate = notificationTemplate;
        notificationTemplate.setContent(order);
    }
    public NotificationTemplate getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(NotificationTemplate notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }


    public void setOrder(SimpleOrder order) {
        this.order = order;
    }

    public SimpleOrder getOrder() {
        return order;
    }

//    public void setChannel(List<Channel> channel) {
//        this.channel = channel;
//    }

}
