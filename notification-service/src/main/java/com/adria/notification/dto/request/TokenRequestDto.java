package com.adria.notification.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequestDto {
    private String token;
    private LocalDateTime expirationDate;
    private RecipientRequestDto recipient;
}
