package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.Vector;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
    public void saveNotification(Notification notification){
        notificationRepository.saveNotification(notification);
    }
    public Queue<Notification>getAllNotifications(){
        return notificationRepository.getAllNotifications();
    }
    public Vector<Notification> getSentNotifications(){
        return notificationRepository.getSentNotifications();
    }
    public List<String> getMostNotifiedPhones(){
        return notificationRepository.getMostNotifiedPhones();
    }
    public List<String> getMostNotifiedEmails(){
        return notificationRepository.getMostNotifiedEmails();
    }
    public List<String> getMostUsedTemplates(){
        return notificationRepository.getMostUsedTemplates();
    }
    public void processNotifications(){
        Notification notification=notificationRepository.processNotifications();
        if(notification!=null){
            for(Channel channel:notification.getChannels()){
                channel.send(notification);
            }
        }

    }

}
