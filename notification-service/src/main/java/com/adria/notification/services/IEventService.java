package com.adria.notification.services;

import com.adria.notification.dto.response.event.EventSimpleResponseDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.event.EventResponseDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
//import com.adria.notification.dto.response.template.SmsTemplateResponseDto;

import java.util.List;
import java.util.UUID;

public interface IEventService {

    EmailTemplateRequestDto saveEmail(EmailTemplateRequestDto emailTemplate);

    //    SmsTemplateRequestDto saveSms(SmsTemplateRequestDto smsTemplate);
    EmailTemplateRequestDto updateEmail(EmailTemplateRequestDto emailTemplate);

    //    SmsTemplateRequestDto updateSms(SmsTemplateRequestDto smsTemplate);
    void deleteEmail(EmailTemplateResponseDto emailTemplate);

    //    void deleteSms(SmsTemplateResponseDto smsTemplate);
    List<EmailTemplateResponseDto> findAllEmail(String type, String appId);

    List<EventSimpleResponseDto> findAllEventNames();

    //    List<SmsTemplateResponseDto> findAllSms(String type);
    EmailTemplateRequestDto findByEventNameAndAppId(String event, String appId);
    EmailTemplateRequestDto findByEventName(String event);

    EventResponseDto findByEventNameOnlyAndAppId(String event, String appId);

    EventResponseDto updateEditable(UUID id, boolean editable);

    EventResponseDto findById(UUID id);
}
