package com.nicmsaraiva.api_notification.repository;

import com.nicmsaraiva.api_notification.domain.PushNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PushRepository extends JpaRepository<PushNotification, Long> {
}
