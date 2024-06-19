package com.adria.notification.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RecipientRequestDto {
    private String email;
    private String phone;
}
