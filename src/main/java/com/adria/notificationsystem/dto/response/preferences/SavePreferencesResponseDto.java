package com.adria.notificationsystem.dto.response.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePreferencesResponseDto {
    private UUID uuid;
    private String recipientEmail;
    private String eventType;
}
