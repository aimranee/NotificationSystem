package com.adria.notification.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferenceTokenDto {
    private String token;
    private RecipientResponseDto recipient;
    private LocalDateTime expirationDate;
}
