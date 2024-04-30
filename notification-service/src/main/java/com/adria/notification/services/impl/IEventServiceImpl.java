package com.adria.notification.services.impl;

import com.adria.notification.dao.IEventDao;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
//import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.mappers.EventMapper;
import com.adria.notification.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class IEventServiceImpl implements IEventService {

    private final IEventDao templateDao;
    private final EventMapper eventMapper;

    @Override
    public EmailTemplateRequestDto saveEmail(EmailTemplateRequestDto emailTemplate) {
        return eventMapper.toEmailTemplateDto(templateDao.saveEmail(emailTemplate));
    }

//    @Override
//    public SmsTemplateRequestDto saveSms(SmsTemplateRequestDto smsTemplate) {
//        return templateMapper.toSmsTemplateDto(templateDao.saveSms(smsTemplate));
//    }

    @Override
    public EmailTemplateRequestDto updateEmail(EmailTemplateRequestDto emailTemplate) {
        return eventMapper.toEmailTemplateDto(templateDao.updateEmail(emailTemplate));
    }

//    @Override
//    public SmsTemplateRequestDto updateSms(SmsTemplateRequestDto smsTemplate) {
//        return templateMapper.toSmsTemplateDto(templateDao.updateSms(smsTemplate));
//    }

    @Override
    public void deleteEmail(EmailTemplateResponseDto emailTemplate) {
        templateDao.deleteEmail(emailTemplate);
    }

//    @Override
//    public void deleteSms(SmsTemplateResponseDto smsTemplate) {
//        templateDao.deleteSms(smsTemplate);
//    }

    @Override
    public List<EmailTemplateResponseDto> findAllEmail(String type) {
        return eventMapper.toEmailTemplateDtoList(templateDao.findAllByNotificationType(type));
    }

    @Override
    public EmailTemplateRequestDto findByEventName(String event) {
        return eventMapper.toEmailTemplateDto(templateDao.findByEventName(event));
    }

    @Override
    public EventResponseDto updateEditable(UUID id, boolean editable) {
        int res = templateDao.updateEditable(id, editable);
        if (res==1){
            return eventMapper.toEventResponseDto(templateDao.findById(id));
        }else{
            return null;
        }
    }

    @Override
    public EventResponseDto findById(UUID id) {
        return eventMapper.toEventResponseDto(templateDao.findById(id));
    }

//    @Override
//    public List<SmsTemplateResponseDto> findAllSms(String type) {
//        return templateMapper.toSmsTemplateDtoList(templateDao.findAllByType(type));
//    }
}
