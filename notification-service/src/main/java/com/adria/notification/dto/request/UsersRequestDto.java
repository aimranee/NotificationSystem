package com.adria.notification.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UsersRequestDto {
    private String firstName;
    private String lastName;
    private String serial;
    private String email;
}
