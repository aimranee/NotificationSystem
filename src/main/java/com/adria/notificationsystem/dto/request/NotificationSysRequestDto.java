package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class NotificationSysRequestDto {
    private EventRequestDto event;
    private RecipientRequestDto recipient;
    private String msgBody;
    private String subject;
    private String result;
}
