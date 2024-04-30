package com.adria.notification.dto.request.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDto {
    private String eventName;
    private boolean editable;
    private String notificationType;
}
