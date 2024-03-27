package com.adria.notification.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class RecipientResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String token;
}
