package com.nicmsaraiva.api_notification.domain;

import com.nicmsaraiva.api_notification.dto.email.CreateEmailDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Email")
@Table(name = "emails")
public class EmailNotification {
    @Id
    @NotBlank
    private Long id;

    @NotBlank
    private Date date;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String content;

    public EmailNotification(CreateEmailDTO emailDTO) {
        this.date = emailDTO.getDate();
        this.email = emailDTO.getEmail();
        this.content = emailDTO.getContent();
    }
}
