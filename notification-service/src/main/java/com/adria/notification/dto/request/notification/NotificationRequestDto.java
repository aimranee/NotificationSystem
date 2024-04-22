package com.adria.notification.dto.request.notification;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Component
public class NotificationRequestDto {
    @NotBlank(message = "Event type must not be blank")
    private String eventName;
    @NotBlank(message = "Email recipient must not be blank")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
    private String emailRecipient;
    @NotBlank(message = "Phone recipient must not be blank")
    @Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number format")
    private String phoneRecipient;
    private String message;
    @NotBlank(message = "Notification type must not be blank")
    private String notificationType;
}
