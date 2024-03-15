package com.adria.notificationsystem.dto.request.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreferencesRequestDto {
    private String recipientEmail;
    private String eventType;
}