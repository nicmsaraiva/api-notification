package com.nicmsaraiva.api_notification.repository;

import com.nicmsaraiva.api_notification.model.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<EmailNotification, Long> {

    @Query("SELECT n FROM EmailNotification n WHERE n.email = :email")
    List<EmailNotification> findByEmail(String email);
}
