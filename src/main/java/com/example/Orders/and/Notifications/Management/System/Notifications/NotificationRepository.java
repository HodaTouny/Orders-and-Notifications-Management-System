package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

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
    public String getMostPhone(){
        Map<String,Integer> phoneCounts=new HashMap<>();
        for(Notification notification:sentNotifications){
            for(Channel channel:notification.getChannels()){
                if(channel instanceof SMS){
                    String phone=notification.getOrder().getCustomer().getPhone();
                    phoneCounts.put(phone,phoneCounts.getOrDefault(phone,0)+1);
                }
            }
        }
        String mostNotifiedPhone=getMaxKey(phoneCounts);
        return mostNotifiedPhone;
    }
    public String getMostNotifiedEmail() {
        Map<String, Integer> emailCounts = new HashMap<>();
        Map<String, Integer> phoneCounts = new HashMap<>();

        for (Notification notification : sentNotifications) {
            for (Channel channel : notification.getChannels()) {
                if (channel instanceof Email) {
                    String email = notification.getOrder().getCustomer().getEmail();
                    emailCounts.put(email, emailCounts.getOrDefault(email, 0) + 1);
                }
            }
        }
        String mostNotifiedEmail = getMaxKey(emailCounts);
        return mostNotifiedEmail;
    }
    public String getMostUsedTemplate() {
        Map<String, Integer> templateCounts = new HashMap<>();
        for (Notification notification : sentNotifications) {
            if (notification.getNotificationTemplate() != null) {
                String subject = notification.getNotificationTemplate().subject;
                templateCounts.put(subject, templateCounts.getOrDefault(subject, 0) + 1);
            }
        }
        String mostUsedTemplate = getMaxKey(templateCounts);
        return mostUsedTemplate;
    }

    private String getMaxKey(Map<String, Integer> map) {
        return map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

}
