package com.adria.notification.services.impl;

import com.adria.notification.dao.ITemplateDao;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SaveEmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.mappers.TemplateMapper;
import com.adria.notification.services.ITemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ITemplateServiceImpl implements ITemplateService {

    private final ITemplateDao templateDao;
    private final TemplateMapper templateMapper;

    @Override
    public EmailTemplateRequestDto saveEmail(EmailTemplateRequestDto emailTemplate) {
        return templateMapper.toEmailTemplateDto(templateDao.saveEmail(emailTemplate));
    }

    @Override
    public SmsTemplateRequestDto saveSms(SmsTemplateRequestDto smsTemplate) {
        return templateMapper.toSmsTemplateDto(templateDao.saveSms(smsTemplate));
    }

    @Override
    public EmailTemplateRequestDto updateEmail(EmailTemplateRequestDto emailTemplate) {
        return templateMapper.toEmailTemplateDto(templateDao.updateEmail(emailTemplate));
    }

    @Override
    public SmsTemplateRequestDto updateSms(SmsTemplateRequestDto smsTemplate) {
        return templateMapper.toSmsTemplateDto(templateDao.updateSms(smsTemplate));
    }

    @Override
    public void deleteEmail(EmailTemplateResponseDto emailTemplate) {
        templateDao.deleteEmail(emailTemplate);
    }

    @Override
    public void deleteSms(SmsTemplateResponseDto smsTemplate) {
        templateDao.deleteSms(smsTemplate);
    }

    @Override
    public List<EmailTemplateResponseDto> findAllEmail(String type) {
        return templateMapper.toEmailTemplateDtoList(templateDao.findAllByType(type));
    }

    @Override
    public List<SmsTemplateResponseDto> findAllSms(String type) {
        return templateMapper.toSmsTemplateDtoList(templateDao.findAllByType(type));
    }
}
