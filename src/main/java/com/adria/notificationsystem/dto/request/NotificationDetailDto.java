package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NotificationDetailDto {
    private EventRequestDto eventDto;
    private RecipientRequestDto recipientDto;
    private String message;
    private String notificationType;
}
