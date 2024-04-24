package com.adria.notification.dto.request.template;

import com.adria.notification.dto.response.EventResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsTemplateRequestDto {
    private String message;
    private String type;
    private String description;
    private String language;
    @Valid
    private EventResponseDto event;
}