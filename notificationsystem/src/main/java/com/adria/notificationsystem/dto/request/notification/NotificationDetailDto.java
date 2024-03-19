package com.adria.notificationsystem.dto.request.notification;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Component
@NoArgsConstructor
public class NotificationDetailDto {
    @Valid
    private EventRequestDto eventDto;
    @Valid
    private RecipientRequestDto recipientDto;
    private String message;
    @NotBlank(message = "Le champ 'notificationType' ne doit pas être vide")
    private String notificationType;
}
