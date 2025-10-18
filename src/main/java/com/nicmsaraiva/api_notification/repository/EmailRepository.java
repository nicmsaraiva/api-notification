package com.nicmsaraiva.api_notification.repository;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailNotification, Long> {

    List<EmailNotification> findByEmail(String email);
}
