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
    private String subject;
    private String type;
    private String description;
    private String language;
    private String emailMarkup;
    private String emailRenderedHtml;
    private String eventName;
}
