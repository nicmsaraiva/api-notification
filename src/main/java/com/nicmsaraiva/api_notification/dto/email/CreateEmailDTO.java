package com.nicmsaraiva.api_notification.dto.email;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class CreateEmailDTO {
    private Date date;
    private String email;
    private String content;
}
