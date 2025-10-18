package com.nicmsaraiva.api_notification.dto.email;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmailDTO {
    @NotBlank
    private String date;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String content;
}
