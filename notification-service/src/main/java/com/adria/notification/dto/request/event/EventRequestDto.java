package com.adria.notification.dto.request.event;

import com.adria.notification.dto.request.VariablesRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequestDto {
    private String eventName;
    private boolean editable;
    private String notificationType;
    private List<VariablesRequestDto> variables;
}
