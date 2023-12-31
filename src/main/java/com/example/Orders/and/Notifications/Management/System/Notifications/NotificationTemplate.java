package com.example.Orders.and.Notifications.Management.System.Notifications;
import com.example.Orders.and.Notifications.Management.System.Users.*;
import com.example.Orders.and.Notifications.Management.System.Orders.*;

import java.util.ArrayList;
import java.util.List;

public abstract class NotificationTemplate {
    String content;
    String subject;
    List<Language> availableLanguages = new ArrayList<>();
    public String getContent() {
        return content;
    }

    abstract public void setContent(SimpleOrder order, Language language);

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
