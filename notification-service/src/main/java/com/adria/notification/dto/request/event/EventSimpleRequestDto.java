package com.adria.notification.dto.request.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventSimpleRequestDto {
    private String eventName;
    private boolean editable;
    private String description;
    private String notificationType;
    private String clientAppId;
}
