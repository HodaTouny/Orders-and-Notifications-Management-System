package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class NotificationRepository {
    Vector<Notification> sentNotifications;
    Queue<Notification>Notifications;
    public NotificationRepository(){
        sentNotifications=new Vector<>();
        Notifications=new LinkedList<>();
    }
    public void saveNotification(Notification message){
        Notifications.add(message);
        System.out.println(Notifications.size());
    }
    public Queue<Notification> getAllNotifications() {
        System.out.println(Notifications.size());
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
    public List<String> getMostNotifiedPhones() {
        Map<String, Integer> phoneCounts = new HashMap<>();

        for (Notification notification : sentNotifications) {
            for (Channel channel : notification.getChannels()) {
                if (channel instanceof SMS) {
                    String phone = notification.getOrder().getCustomer().getPhone();
                    phoneCounts.put(phone, phoneCounts.getOrDefault(phone, 0) + 1);
                }
            }
        }

        return getMaxKeys(phoneCounts);
    }

    public List<String> getMostNotifiedEmails() {
        Map<String, Integer> emailCounts = new HashMap<>();

        for (Notification notification : sentNotifications) {
            for (Channel channel : notification.getChannels()) {
                if (channel instanceof Email) {
                    String email = notification.getOrder().getCustomer().getEmail();
                    emailCounts.put(email, emailCounts.getOrDefault(email, 0) + 1);
                }
            }
        }

        return getMaxKeys(emailCounts);
    }

    public List<String> getMostUsedTemplates() {
        Map<String, Integer> templateCounts = new HashMap<>();

        for (Notification notification : sentNotifications) {
            if (notification.getNotificationTemplate() != null) {
                String subject = notification.getNotificationTemplate().subject;
                templateCounts.put(subject, templateCounts.getOrDefault(subject, 0) + 1);
            }
        }

        return getMaxKeys(templateCounts);
    }

    private List<String> getMaxKeys(Map<String, Integer> map) {
        int maxCount = map.values().stream().max(Integer::compare).orElse(0);

        List<String> maxKeys = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return maxKeys.isEmpty() ? null : maxKeys;
    }

}
