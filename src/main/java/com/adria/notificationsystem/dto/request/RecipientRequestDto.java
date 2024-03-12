package com.adria.notificationsystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class RecipientRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String token;
}
