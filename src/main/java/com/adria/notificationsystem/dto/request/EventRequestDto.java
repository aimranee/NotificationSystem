package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventRequestDto {
    private String eventType;
    private boolean editable;
    private String message;
    private String subject;
}
