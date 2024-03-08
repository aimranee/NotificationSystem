package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventRequestDto {
    private EventTypeRequestDto type;
    private boolean editable;
}
