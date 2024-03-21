package com.adria.notification.dto.response.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SavePreferencesResponseDto {
    private UUID uuid;
    private String recipientEmail;
    private String eventType;
}
