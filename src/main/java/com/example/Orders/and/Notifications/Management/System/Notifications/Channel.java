package com.example.Orders.and.Notifications.Management.System.Notifications;

public abstract class Channel {
    public Channel() {
    }
    public abstract void send(Notification notification);
}
