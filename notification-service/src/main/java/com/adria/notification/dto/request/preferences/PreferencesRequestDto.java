package com.adria.notification.dto.request.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PreferencesRequestDto {
    private String recipientEmail;
    private String eventName;
}