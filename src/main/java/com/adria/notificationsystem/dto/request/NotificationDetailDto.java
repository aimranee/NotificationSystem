package com.adria.notificationsystem.dto.request;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Component
public class NotificationDetailDto {
    @Valid
    private EventRequestDto eventDto;
    @Valid
    private RecipientRequestDto recipientDto;
    private String message;
    @NotBlank(message = "Le champ 'notificationType' ne doit pas être vide")
    private String notificationType;
}
