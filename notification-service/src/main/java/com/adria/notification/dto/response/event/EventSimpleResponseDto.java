package com.adria.notification.dto.response.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSimpleResponseDto {
    private UUID id;
    private String eventName;
    private boolean editable;
    private String description;
    private String notificationType;
}
