package com.adria.notification.mappers;

import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.models.entities.Template;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface TemplateMapper {
    @Mapping(target = "event.id", source = "event.id")
    EmailTemplateRequestDto toEmailTemplateDto(Template template);
    @Mapping(target = "eventName", source = "event.name")
    EmailTemplateResponseDto toEmailResponseTemplateDto(Template template);
    @Mapping(target = "eventName", source = "event.name")
    SmsTemplateResponseDto toSmsResponseTemplateDto(Template template);
    @Mapping(source = "event.id", target = "event.id")
    Template toEmailTemplateEntity(EmailTemplateRequestDto templateDto);
    @Mapping(source = "eventName", target = "event.name")
    Template toEmailTemplateEntity(EmailTemplateResponseDto templateDto);
    @Mapping(target = "event.id", source = "event.id")
    SmsTemplateRequestDto toSmsTemplateDto(Template template);
    @Mapping(source = "event.id", target = "event.id")
    Template toSmsTemplateEntity(SmsTemplateRequestDto templateDto);
    @Mapping(source = "eventName", target = "event.name")
    Template toSmsTemplateEntity(SmsTemplateResponseDto templateDto);
    List<EmailTemplateResponseDto> toEmailTemplateDtoList(List<Template> templates);
    List<SmsTemplateResponseDto> toSmsTemplateDtoList(List<Template> templates);

}
