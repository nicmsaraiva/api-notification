package com.nicmsaraiva.api_notification.domain.email;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import com.nicmsaraiva.api_notification.enums.EmailStatus;
import jakarta.validation.constraints.Email;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EmailNotificationTest {

    @Test
    void shouldCreateEmailNotificationFromDto() {
        LocalDate sent = LocalDate.of(2026, 2, 2);
        CreateEmailDTO dto = new CreateEmailDTO("Test subject", sent, "user@example.com", "Hello content");

        EmailNotification email = new EmailNotification(dto);
        assertEquals("Test subject", email.getSubject());
        assertEquals(sent, email.getSentDate());
        assertEquals("user@example.com", email.getEmail());
        assertEquals("Hello content", email.getContent());
        assertNotNull(email.getCreatedDate());
        assertEquals(EmailStatus.CREATED, email.getStatus());
    }
}
