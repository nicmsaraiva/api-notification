package com.nicmsaraiva.api_notification.service;

import com.nicmsaraiva.api_notification.domain.PushNotification;
import com.nicmsaraiva.api_notification.dto.push.CreatePushDTO;
import com.nicmsaraiva.api_notification.repository.PushRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PushService {

    private final PushRepository repository;

    @Autowired
    public PushService(PushRepository repository) {
        this.repository = repository;
    }

    public void save(CreatePushDTO createPushDTO) {
        repository.save(new PushNotification(createPushDTO));
    }

    public List<PushNotification> getPushes() {
        return repository.findAll();
    }

    public Optional<PushNotification> getById(Long id) {
        return repository.findById(id);
    }
}
