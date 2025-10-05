package com.nicmsaraiva.api_notification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class EmailNotification {
    @Id @NotBlank
    private Long id;
    @DateTimeFormat @NotBlank
    private String datetime;
    @Email @NotBlank
    private String email;
    @NotBlank
    private String content;
}
