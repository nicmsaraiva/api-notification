package com.nicmsaraiva.api_notification.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorResponse {
    String field;
    Object rejectValue;
    String message;
}
