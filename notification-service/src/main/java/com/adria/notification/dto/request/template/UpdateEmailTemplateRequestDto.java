package com.adria.notification.dto.request.template;

import com.adria.notification.dto.response.EmailProviderResponseDto;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmailTemplateRequestDto {
    private UUID id;
    private String eventName;
    private boolean editable;
    private String notificationType;
    private String subject;
    private String description;
    private String language;
    private String emailMarkup;
    private String emailRenderedHtml;
    private String variables;
    @Valid
    private EmailProviderResponseDto emailProvider;
}
