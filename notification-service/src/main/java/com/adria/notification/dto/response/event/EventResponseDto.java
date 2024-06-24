package com.adria.notification.dto.response.event;

import com.adria.notification.dto.response.ClientResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventResponseDto {
    private UUID id;
    private String eventName;
    private boolean editable;
    private String notificationType;
    private String clientAppId;
}
