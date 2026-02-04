package com.nicmsaraiva.api_notification.domain.push;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import com.nicmsaraiva.api_notification.enums.EmailStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PushNotificationTest {

    @Test
    void shouldCreateEmailNotificationFromDto() {
        LocalDate sent = LocalDate.of(2026, 2, 2);
        CreateEmailDTO dto = new CreateEmailDTO("Test subject", sent, "user@example.com", "Hello content");

        EmailNotification entity = new EmailNotification(dto);

        assertEquals("Test subject", entity.getSubject());
        assertEquals(sent, entity.getSentDate());
        assertEquals("user@example.com", entity.getEmail());
        assertEquals("Hello content", entity.getContent());
        assertNotNull(entity.getCreatedDate());
        assertEquals(EmailStatus.CREATED, entity.getStatus());
    }
}
