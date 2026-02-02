// src/test/java/com/nicmsaraiva/api_notification/dto/email/ReadEmailDTOTest.java
package com.nicmsaraiva.api_notification.dto.email;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadEmailDTOTest {

    @Test
    void shouldMapFromEmailNotification() {
        EmailNotification entity = new EmailNotification();
        entity.setId(123L);
        entity.setSubject("Subject X");
        LocalDate sent = LocalDate.of(2026, 2, 2);
        entity.setSentDate(sent);
        entity.setEmail("a@b.com");
        entity.setContent("Some content");

        ReadEmailDTO dto = new ReadEmailDTO(entity);
        assertEquals(123L, dto.getId());
        assertEquals("Subject X", dto.getSubject());
        assertEquals(sent, dto.getSentDate());
        assertEquals("a@b.com", dto.getEmail());
        assertEquals("Some content", dto.getContent());
    }
}
