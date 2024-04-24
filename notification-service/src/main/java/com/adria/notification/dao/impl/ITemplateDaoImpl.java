package com.adria.notification.dao.impl;

import com.adria.notification.dao.ITemplateDao;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.mappers.TemplateMapper;
import com.adria.notification.models.entities.Template;
import com.adria.notification.repositories.TemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ITemplateDaoImpl implements ITemplateDao {

    private final TemplateRepository templateRepository;
    private final TemplateMapper templateMapper;

    @Override
    public Template saveEmail(EmailTemplateRequestDto emailTemplate) {
        return templateRepository.save(templateMapper.toEmailTemplateEntity(emailTemplate));
    }

    @Override
    public Template saveSms(SmsTemplateRequestDto smsTemplate) {
        return templateRepository.save(templateMapper.toSmsTemplateEntity(smsTemplate));
    }

    @Override
    public Template updateEmail(EmailTemplateRequestDto emailTemplate) {
        return templateRepository.save(templateMapper.toEmailTemplateEntity(emailTemplate));
    }

    @Override
    public Template updateSms(SmsTemplateRequestDto smsTemplate) {
        return templateRepository.save(templateMapper.toSmsTemplateEntity(smsTemplate));
    }

    @Override
    public List<Template> findAllByType(String type) {
        return templateRepository.findAllByType(type);
    }

    @Override
    public void deleteEmail(EmailTemplateResponseDto emailTemplate) {
        templateRepository.delete(templateMapper.toEmailTemplateEntity(emailTemplate));
    }

    @Override
    public void deleteSms(SmsTemplateResponseDto smsTemplate) {
        templateRepository.delete(templateMapper.toSmsTemplateEntity(smsTemplate));
    }
}
