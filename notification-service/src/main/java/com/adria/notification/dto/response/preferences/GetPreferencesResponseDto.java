package com.adria.notification.dto.response.preferences;

import com.adria.notification.dto.request.event.EventSimpleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GetPreferencesResponseDto {
    @Valid
    private EventSimpleRequestDto event;
    @Valid
    private EventSimpleRequestDto recipient;
}
