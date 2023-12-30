package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Repository
public class NotificationRepository {
    Vector<Notification> sentNotifications;
    Queue<Notification>Notifications;
    public void saveNotification(Notification message){
        Notifications.add(message);

    }
    public Queue<Notification> getAllNotifications() {
        return Notifications;
    }
    public Vector<Notification> getSentNotifications() {
        return sentNotifications;
    }
    public Notification processNotifications() {
        while (!Notifications.isEmpty()) {
            Notification notification = Notifications.poll();
            sentNotifications.add(notification);
            return notification;
        }
        return null;
    }
    public String getMostNotifiedEmail() {
        Vector<String> resultVector = getMostNotifiedEmailAndPhoneNumber();
        return (resultVector != null && resultVector.size() >= 1) ? resultVector.get(0) : null;
    }

    public String getMostNotifiedPhoneNumber() {
        Vector<String> resultVector = getMostNotifiedEmailAndPhoneNumber();
        return (resultVector != null && resultVector.size() >= 2) ? resultVector.get(1) : null;
    }

    public Vector<String> getMostNotifiedEmailAndPhoneNumber() {
        Map<String, Integer> emailCounts = new HashMap<>();
        Map<String, Integer> phoneCounts = new HashMap<>();

        for (Notification notification : sentNotifications) {
            for (Channel channel : notification.getChannels()) {
                if (channel instanceof Email) {
                    String email = notification.getOrder().getCustomer().getEmail();
                    emailCounts.put(email, emailCounts.getOrDefault(email, 0) + 1);
                } else if (channel instanceof SMS) {
                    String phone = notification.getOrder().getCustomer().getPhone();
                    phoneCounts.put(phone, phoneCounts.getOrDefault(phone, 0) + 1);
                }
            }
        }
        String mostNotifiedEmail = getMaxKey(emailCounts);
        int maxEmailCount = emailCounts.getOrDefault(mostNotifiedEmail, 0);

        String mostNotifiedPhone = getMaxKey(phoneCounts);
        int maxPhoneCount = phoneCounts.getOrDefault(mostNotifiedPhone, 0);
        Vector<String> resultVector = new Vector<>();
        resultVector.add(mostNotifiedEmail);
        resultVector.add(mostNotifiedPhone);

        return resultVector;
    }

    private String getMaxKey(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

}
