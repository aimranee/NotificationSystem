package com.adria.notification.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EventRequestDto {
    private String name;
    private boolean editable;
}
