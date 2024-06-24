package com.adria.notification.dto.request.notification;

import com.adria.notification.dto.request.event.EventRequestDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Component
public class NotificationRequestDto {
    private List<EventRequestDto> event;
    @NotBlank(message = "Email recipient must not be blank")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email format")
    private String emailRecipient;
    @NotBlank(message = "Phone recipient must not be blank")
    @Pattern(regexp = "\\+?[0-9]+", message = "Invalid phone number format")
    private String phoneRecipient;
    private String clientAppId;
}
