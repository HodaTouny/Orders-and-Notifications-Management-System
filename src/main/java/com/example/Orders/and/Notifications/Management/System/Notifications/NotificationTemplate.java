package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;

import javax.management.Notification;
import java.util.Queue;

public abstract class NotificationTemplate {
    private Customer customer;
    private Order order;
    private String subject;
    private String body;
    private Queue<String> notifications;
    private Channel channel;

    public NotificationTemplate(String subject, String body) {
        this.customer = customer;
        this.order = order;
        this.subject = subject;
        this.body = body;
    }
    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
    public abstract  void setBody();
}
