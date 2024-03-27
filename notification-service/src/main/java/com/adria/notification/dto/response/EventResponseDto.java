package com.adria.notification.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class EventResponseDto {
    private UUID uuid;
    private String type;
    private boolean editable;
    private String message;
    private String subject;
}
