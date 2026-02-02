package com.nicmsaraiva.api_notification.domain;

import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import com.nicmsaraiva.api_notification.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Email")
@Table(name = "emails")
public class EmailNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private LocalDateTime createdDate;
    private LocalDateTime sentDate;
    private String email;
    private String content;
    @Enumerated(EnumType.STRING)
    private EmailStatus status;

    public EmailNotification(CreateEmailDTO emailDTO) {
        this.subject = emailDTO.getSubject();
        this.createdDate = LocalDateTime.now();
        this.sentDate = emailDTO.getSentDate();
        this.email = emailDTO.getEmail();
        this.content = emailDTO.getContent();
        this.status = EmailStatus.CREATED;
    }
}
