package com.nicmsaraiva.api_notification.dto.push;

import com.nicmsaraiva.api_notification.domain.PushNotification;
import com.nicmsaraiva.api_notification.enums.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadPushDTO {
    private Long id;
    private String title;
    private String message;
    private String deviceToken;
    private LocalDate sentDate;
    private MessageStatus status;

    public ReadPushDTO(PushNotification pushNotification) {
        this.id = pushNotification.getId();
        this.title = pushNotification.getTitle();
        this.message = pushNotification.getMessage();
        this.deviceToken = pushNotification.getDeviceToken();
        this.sentDate = pushNotification.getSentDate();
        this.status = pushNotification.getStatus();
    }
}
