package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class EmailRequestDto {
    private String eventType;
    private String email;
    private String firstName;
    private String lastName;
}
