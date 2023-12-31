package com.example.Orders.and.Notifications.Management.System.Notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

@RestController
@RequestMapping(path = "/notification/api")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/all")
    public ResponseEntity<Queue<Notification>> getAllNotification() {
        Queue<Notification> notifications = notificationService.getAllNotifications();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        if(!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
        return new ResponseEntity<>(notifications, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sent")
    public ResponseEntity<Vector<Notification>> getSentNotifications() {
        Vector<Notification> notifications = notificationService.getSentNotifications();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        if (!notifications.isEmpty()) {
            return new ResponseEntity<>(notifications, HttpStatus.OK);
        }
        return new ResponseEntity<>(notifications, HttpStatus.NOT_FOUND);
    }

    public void saveNotification(Notification notification) {
        notificationService.saveNotification(notification);
    }

    @Scheduled(fixedRate = 5000)
    public void processNotifications() {
        notificationService.processNotifications();
    }

    @GetMapping("/mostPhones")
    public ResponseEntity<List<String>> getMostNotifiedPhones() {
        List<String> mostPhones = notificationService.getMostNotifiedPhones();
        if (!mostPhones.isEmpty()) {
            return new ResponseEntity<>(mostPhones, HttpStatus.OK);
        }
        return new ResponseEntity<>(mostPhones, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mostEmails")
    public ResponseEntity<List<String>> getMostNotifiedEmails() {
        List<String> mostEmails = notificationService.getMostNotifiedEmails();
        if (!mostEmails.isEmpty()) {
            return new ResponseEntity<>(mostEmails, HttpStatus.OK);
        }
        return new ResponseEntity<>(mostEmails, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/mostTemplates")
    public ResponseEntity<List<String>> getMostUsedTemplates() {
        List<String> mostUsedTemplates = notificationService.getMostUsedTemplates();
        if (!mostUsedTemplates.isEmpty()) {
            return new ResponseEntity<>(mostUsedTemplates, HttpStatus.OK);
        }
        return new ResponseEntity<>(mostUsedTemplates, HttpStatus.NOT_FOUND);
    }
}
