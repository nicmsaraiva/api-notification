package com.nicmsaraiva.api_notification.dto.email;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmailDTO {
    @NotBlank(message = "Subject cannot be blank")
    @Size(min = 10, max = 100, message = "Subject must be between 10 and 100 characters")
    private String subject;

    @NotNull(message = "Sent date cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sentDate;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 10, max = 50, message = "Email must be between 10 and 50 characters")
    private String email;

    @NotBlank(message = "Content cannot be blank")
    @Size(max = 500, message = "Content must be at most 500 characters")
    private String content;
}
