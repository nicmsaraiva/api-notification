package com.nicmsaraiva.api_notification.dto.email;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmailDTO {
    @NotBlank(message = "Subject cannot be blank")
    @Size(min = 10, message = "Subject must be have minimum 10 characters")
    @Size(max = 100, message = "Subject must be have maximum 100 characters")
    private String subject;

    @NotNull(message = "Sent date cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sentDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 10, message = "Email must be have minimum 10 characters")
    @Size(max = 50, message = "Email must be have maximum 50 characters")
    private String email;

    @NotBlank(message = "Content cannot be blank")
    @Size(max = 500, message = "Content must be have maximum 500 characters")
    private String content;
}
