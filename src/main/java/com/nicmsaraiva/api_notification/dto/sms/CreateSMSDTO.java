package com.nicmsaraiva.api_notification.dto.sms;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class CreateSMSDTO {
    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 9, max = 11, message = "Phone number must be between 9 and 11 characters")
    private String phoneNumber;

    @NotNull(message = "Sent date cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sentDate;

    @NotBlank(message = "Message cannot be blank")
    @Size(max = 150, message = "message must be at most 150 characters")
    private String message;
}
