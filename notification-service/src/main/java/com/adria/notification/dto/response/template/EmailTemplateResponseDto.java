package com.adria.notification.dto.response.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailTemplateResponseDto {
    private UUID id;
    private boolean editable;
    private String notificationType;
    private String subject;
    private String description;
    private String language;
    private String emailMarkup;
    private String emailRenderedHtml;
    private String eventName;
    private String emailProviderName;
    private String variables;
}
