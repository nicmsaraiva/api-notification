package com.nicmsaraiva.api_notification.domain;

import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String date;
    private String email;
    private String content;

    public EmailNotification(CreateEmailDTO emailDTO) {
        this.date = emailDTO.getDate();
        this.email = emailDTO.getEmail();
        this.content = emailDTO.getContent();
    }
}
