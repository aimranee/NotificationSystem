package com.adria.notification.dto.response.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PreferencesResponseDto {
    private String eventName;
    private String recipientEmail;
}
