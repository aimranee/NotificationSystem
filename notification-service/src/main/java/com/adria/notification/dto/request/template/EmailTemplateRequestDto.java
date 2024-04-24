package com.adria.notification.dto.request.template;

import com.adria.notification.dto.response.EventResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailTemplateRequestDto {
    private String subject;
    private String type;
    private String description;
    private String language;
    private String emailMarkup;
    private String emailRenderedHtml;
    @Valid
    private EventResponseDto event;
}
