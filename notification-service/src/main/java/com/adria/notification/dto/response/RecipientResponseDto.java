package com.adria.notification.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class RecipientResponseDto {
    private UUID id;
    private String email;
    private String phone;
}
