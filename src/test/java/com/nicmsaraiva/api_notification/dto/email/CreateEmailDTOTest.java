// src/test/java/com/nicmsaraiva/api_notification/dto/email/ReadEmailDTOTest.java
package com.nicmsaraiva.api_notification.dto.email;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateEmailDTOTest {

    @Test
    void shouldMapFromEmailNotificationToDTO() {
        EmailNotification email = new EmailNotification();
        email.setSubject("Subject X");
        LocalDate sent = LocalDate.of(2026, 2, 2);
        email.setSentDate(sent);
        email.setEmail("a@b.com");
        email.setContent("Some content");

        ReadEmailDTO dto = new ReadEmailDTO(email);
        assertEquals("Subject X", dto.getSubject());
        assertEquals(sent, dto.getSentDate());
        assertEquals("a@b.com", dto.getEmail());
        assertEquals("Some content", dto.getContent());
    }
}
