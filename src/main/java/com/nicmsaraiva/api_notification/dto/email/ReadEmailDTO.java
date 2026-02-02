package com.nicmsaraiva.api_notification.dto.email;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadEmailDTO {
    private Long id;
    private String subject;
    private LocalDateTime sentDate;
    private String email;
    private String content;

    public ReadEmailDTO(EmailNotification emailNotification) {
        this.id = emailNotification.getId();
        this.subject = emailNotification.getSubject();
        this.sentDate = emailNotification.getSentDate();
        this.email = emailNotification.getEmail();
        this.content = emailNotification.getContent();
    }
}
