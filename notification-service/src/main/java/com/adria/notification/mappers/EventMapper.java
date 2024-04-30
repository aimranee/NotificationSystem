package com.adria.notification.mappers;

import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
//import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.models.entities.Event;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface EventMapper {
    @Mapping(target = "emailProvider.id", source = "emailProvider.id")
    EmailTemplateRequestDto toEmailTemplateDto(Event event);

    @Mapping(target = "emailProviderName", source = "emailProvider.name")
    EmailTemplateResponseDto templateToEmailTemplateResponseDto(Event event);

    EventResponseDto toEventResponseDto(Event event);

//    @Mapping(target = "eventName", source = "event.name")
//    @Mapping(target = "emailProviderName", source = "emailProvider.name")
//    SmsTemplateResponseDto toSmsResponseTemplateDto(Template template);
    @Mapping(source = "emailProvider.id", target = "emailProvider.id")
    Event toEmailTemplateEntity(EmailTemplateRequestDto templateDto);
    @Mapping(source = "emailProviderName", target = "emailProvider.name")
    Event toEmailTemplateEntity(EmailTemplateResponseDto templateDto);
//    @Mapping(target = "event.id", source = "event.id")
//    @Mapping(target = "emailProvider.id", source = "emailProvider.id")
//    SmsTemplateRequestDto toSmsTemplateDto(Template template);
//    @Mapping(source = "event.id", target = "event.id")
//    @Mapping(source = "emailProvider.id", target = "emailProvider.id")
//    Template toSmsTemplateEntity(SmsTemplateRequestDto templateDto);
//    @Mapping(source = "eventName", target = "event.name")
//    @Mapping(source = "emailProviderName", target = "emailProvider.name")
//    Template toSmsTemplateEntity(SmsTemplateResponseDto templateDto);

    List<EmailTemplateResponseDto> toEmailTemplateDtoList(List<Event> events);
//    List<SmsTemplateResponseDto> toSmsTemplateDtoList(List<Template> templates);

}
