package com.nicmsaraiva.api_notification.service;

import com.nicmsaraiva.api_notification.model.EmailNotification;
import com.nicmsaraiva.api_notification.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;

    public void save(EmailNotification notification) {
        repository.save(notification);
    }

    public void getAll() {
        repository.findAll();
    }

    public void getById(Long id) {
        repository.findById(id);
    }
}
