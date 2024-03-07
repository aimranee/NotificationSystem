package com.adria.notificationsystem.dto.response;

import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class NotificationSysResponseDto {
    private UUID id;
    private EventResponseDto event;
    private RecipientRequestDto recipient;
    private String msgBody;
    private String subject;
    private String result;
}
