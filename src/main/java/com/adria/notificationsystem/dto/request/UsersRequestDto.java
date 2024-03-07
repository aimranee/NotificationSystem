package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
public class UsersRequestDto {
    private String firstName;
    private String lastName;
    private String serial;
    private String email;
}
