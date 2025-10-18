package com.nicmsaraiva.api_notification.service;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import com.nicmsaraiva.api_notification.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmailService {

    private final EmailRepository repository;

    @Autowired
    public EmailService(EmailRepository repository) {
        this.repository = repository;
    }

    public void save(CreateEmailDTO createEmailDTO) {
        repository.save(new EmailNotification(createEmailDTO));
    }

    public List<EmailNotification> getEmails() {
        return repository.findAll();
    }

    public Optional<EmailNotification> getById(Long id) {
        return repository.findById(id);
    }
}
