package com.adria.notification.dao;

import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.models.entities.Template;

import java.util.List;

public interface ITemplateDao {
    Template saveEmail(EmailTemplateRequestDto emailTemplate);
    Template saveSms(SmsTemplateRequestDto smsTemplate);
    Template updateEmail(EmailTemplateRequestDto emailTemplate);
    Template updateSms(SmsTemplateRequestDto smsTemplate);
    List<Template> findAllByType(String type);
    void deleteEmail(EmailTemplateResponseDto emailTemplate);
    void deleteSms(SmsTemplateResponseDto smsTemplate);
}
