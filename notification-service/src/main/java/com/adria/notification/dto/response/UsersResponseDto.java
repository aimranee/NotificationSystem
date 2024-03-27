package com.adria.notification.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class UsersResponseDto {
    private UUID uuid;
    private String firstName;
    private String lastName;
    private String serial;
    private String email;
}
