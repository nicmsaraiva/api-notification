package com.nicmsaraiva.api_notification.dto.push;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class CreatePushDTO {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 10, max = 150, message = "Title must be between 10 and 100 characters")
    private String title;

    @NotBlank(message = "Message cannot be blank")
    @Size(max = 500, message = "Message must be at most 500 characters")
    private String message;

    @NotEmpty(message = "Device token cannot be empty")
    @Size(min = 10, max = 50, message = "Device token  must be between 10 and 50 characters")
    private String deviceToken;

    @NotNull(message = "Sent date cannot be null")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sentDate;
}
