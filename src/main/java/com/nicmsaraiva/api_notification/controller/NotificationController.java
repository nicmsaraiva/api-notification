package com.nicmsaraiva.api_notification.controller;

import com.nicmsaraiva.api_notification.model.EmailNotification;
import com.nicmsaraiva.api_notification.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final EmailService service;

    public NotificationController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/email")
    public void createEmail(@RequestBody EmailNotification notification) {
        service.save(notification);
    }

    @GetMapping("/email")
    public void getEmails() {
        service.getAll();
    }

    @GetMapping("/email/{id}")
    public void getEmailById(Long id) {
        service.getById(id);
    }
}
