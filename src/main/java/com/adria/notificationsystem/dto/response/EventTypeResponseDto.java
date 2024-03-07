package com.adria.notificationsystem.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class EventTypeResponseDto {
    private UUID id;
    private String title;
}
