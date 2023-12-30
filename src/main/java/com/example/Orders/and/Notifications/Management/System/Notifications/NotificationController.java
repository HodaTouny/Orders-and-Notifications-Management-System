package com.example.Orders.and.Notifications.Management.System.Notifications;

import com.example.Orders.and.Notifications.Management.System.Orders.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping(path = "api/v1/notification")
public class NotificationController {
    private  NotificationService notificationService;
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    @GetMapping("/all")
    public ResponseEntity<Queue<Notification>> getAllNotification(){
        Queue<Notification> notifications = notificationService.getAllNotifications();
        if(!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
        return new ResponseEntity<>(notifications, HttpStatus.NOT_FOUND);
    }
    public void saveNotification(Notification notification){
        notificationService.saveNotification(notification);
    }
   // @Scheduled(fixedRate = 5000) // Run every 5 seconds
//    public void processNotifications(){
//        notificationService.processNotifications();
//    }
    @GetMapping("/sent")
    public void getSentNotifications(){
        notificationService.getSentNotifications();
    }
   // @GetMapping("/mostPhone")
//    public String getMostPhone(){
//        return notificationService.getMostPhone();
//    }
//    @GetMapping("/mostEmail")
//    public String getMostNotifiedEmail(){
//        return notificationService.getMostNotifiedEmail();
//    }
    @GetMapping("/mostTemplate")
    public String getMostUsedTemplate(){
        return notificationService.getMostUsedTemplate();
    }


}
