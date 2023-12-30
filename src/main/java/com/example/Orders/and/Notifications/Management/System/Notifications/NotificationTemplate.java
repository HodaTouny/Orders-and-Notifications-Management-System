package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;

import javax.management.Notification;
import java.util.Queue;

public abstract class NotificationTemplate {
    String content;

    String subject;
    public String getContent() {
        return content;
    }

    abstract public void setContent(SimpleOrder order);

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
