package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NotificationRequestDto {
    private String eventType;
    private String emailRecipient;
    private String phoneRecipient;
    private String message;
}
