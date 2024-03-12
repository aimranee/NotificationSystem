package com.adria.notificationsystem.dto.response;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class UsersResponseDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String serial;
    private String email;
}