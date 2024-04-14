package com.adria.notification.dto.request.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SavePreferencesRequestDto {
    @NotBlank
    private String recipientEmail;
    @NotBlank
    private String eventName;
}
