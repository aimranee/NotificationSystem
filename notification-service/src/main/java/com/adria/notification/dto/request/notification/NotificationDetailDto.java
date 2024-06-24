package com.adria.notification.dto.request.notification;

import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.RecipientRequestDto;
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
    @NotBlank(message = "The 'notification Type' field must not be empty")
    private String notificationType;
    private String clientAppId;
}
