package com.adria.notificationsystem.dto.request.preferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavePreferencesRequestDto {
    @NotBlank
    private String recipientEmail;
    @NotBlank
    private String eventType;
}
