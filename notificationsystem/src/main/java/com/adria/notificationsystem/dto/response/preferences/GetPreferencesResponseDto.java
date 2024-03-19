package com.adria.notificationsystem.dto.response.preferences;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.request.RecipientRequestDto;
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
    private EventRequestDto event;
    @Valid
    private RecipientRequestDto recipient;
}
