package com.adria.notificationsystem.dto.response;

import com.adria.notificationsystem.dto.request.EventTypeRequestDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class EventResponseDto {
    private UUID id;
    private EventTypeRequestDto type;
    private boolean editable;
}
