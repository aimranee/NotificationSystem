package com.adria.notification.dao;

import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
//import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.models.entities.Event;

import java.util.List;
import java.util.UUID;

public interface IEventDao {
    int updateEditable(UUID id, boolean editable);

    Event findById(UUID id);

    List<Event> findAllEventNames();

    Event saveEmail(EmailTemplateRequestDto emailTemplate);

    //    Template saveSms(SmsTemplateRequestDto smsTemplate);
    Event updateEmail(EmailTemplateRequestDto emailTemplate);

    //    Template updateSms(SmsTemplateRequestDto smsTemplate);
    List<Event> findAllByNotificationType(String type, String appId);

    void deleteEmail(EmailTemplateResponseDto emailTemplate);

    //    void deleteSms(SmsTemplateResponseDto smsTemplate);
    Event findByEventName(String event);

    Event findByEventNameAndAppId(String event, String appId);
}
