package com.adria.notificationsystem.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class EventResponseDto {
    private UUID uuid;
    private String eventType;
    private boolean editable;
    private String message;
    private String subject;
}
