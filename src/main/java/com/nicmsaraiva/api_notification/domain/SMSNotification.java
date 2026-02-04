package com.nicmsaraiva.api_notification.domain;

import com.nicmsaraiva.api_notification.dto.sms.CreateSMSDTO;
import com.nicmsaraiva.api_notification.enums.MessageStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "SMS")
@Table(name = "smss")
public class SMSNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String message;
    private LocalDateTime createdDate;
    private LocalDateTime sentDate;
    private MessageStatus status;

    public SMSNotification(CreateSMSDTO dto) {
        this.phoneNumber = dto.getPhoneNumber();
        this.message = dto.getMessage();
        this.createdDate = LocalDateTime.now();
        this.status = MessageStatus.CREATED;
    }
}

