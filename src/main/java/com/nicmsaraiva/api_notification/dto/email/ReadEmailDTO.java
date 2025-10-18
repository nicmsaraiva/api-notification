package com.nicmsaraiva.api_notification.dto.email;

import com.nicmsaraiva.api_notification.domain.EmailNotification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadEmailDTO {
    private Long id;
    private String date;
    private String email;
    private String content;

    public ReadEmailDTO(EmailNotification emailNotification) {
        this.id = emailNotification.getId();
        this.date = emailNotification.getDate();
        this.email = emailNotification.getEmail();
        this.content = emailNotification.getContent();
    }
}
