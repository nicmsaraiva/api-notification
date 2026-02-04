package com.nicmsaraiva.api_notification.domain;

import com.nicmsaraiva.api_notification.dto.push.CreatePushDTO;
import com.nicmsaraiva.api_notification.enums.MessageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "Push")
@Table(name = "pushes")
public class PushNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private String deviceToken;
    private LocalDateTime createdDate;
    private LocalDate sentDate;
    @Enumerated(EnumType.STRING)
    private MessageStatus status;

    public PushNotification(CreatePushDTO dto) {
        this.title = dto.getTitle();
        this.message = dto.getMessage();
        this.deviceToken = dto.getDeviceToken();
        this.createdDate = LocalDateTime.now();
        this.sentDate = dto.getSentDate();
        this.status = MessageStatus.CREATED;
    }
}
