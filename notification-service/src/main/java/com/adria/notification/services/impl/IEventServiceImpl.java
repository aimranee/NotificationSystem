package com.adria.notification.services.impl;

import com.adria.notification.dao.IEventDao;
import com.adria.notification.dto.response.event.EventSimpleResponseDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.event.EventResponseDto;
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

    private final IEventDao eventDao;
    private final EventMapper eventMapper;

    @Override
    public EmailTemplateRequestDto saveEmail(EmailTemplateRequestDto emailTemplate) {
        return eventMapper.toEmailTemplateDto(eventDao.saveEmail(emailTemplate));
    }

//    @Override
//    public SmsTemplateRequestDto saveSms(SmsTemplateRequestDto smsTemplate) {
//        return templateMapper.toSmsTemplateDto(eventDao.saveSms(smsTemplate));
//    }

    @Override
    public EmailTemplateRequestDto updateEmail(EmailTemplateRequestDto emailTemplate) {
        return eventMapper.toEmailTemplateDto(eventDao.updateEmail(emailTemplate));
    }

//    @Override
//    public SmsTemplateRequestDto updateSms(SmsTemplateRequestDto smsTemplate) {
//        return eventMapper.toSmsTemplateDto(eventDao.updateSms(smsTemplate));
//    }

    @Override
    public void deleteEmail(EmailTemplateResponseDto emailTemplate) {
        eventDao.deleteEmail(emailTemplate);
    }

//    @Override
//    public void deleteSms(SmsTemplateResponseDto smsTemplate) {
//        eventDao.deleteSms(smsTemplate);
//    }

    @Override
    public List<EmailTemplateResponseDto> findAllEmail(String type) {
        return eventMapper.toEmailTemplateDtoList(eventDao.findAllByNotificationType(type));
    }

    @Override
    public List<EventSimpleResponseDto> findAllEventNames() {
        return eventMapper.toEventReponseDtoList(eventDao.findAllEventNames());
    }

    @Override
    public EmailTemplateRequestDto findByEventName(String event) {
        return eventMapper.toEmailTemplateDto(eventDao.findByEventName(event));
    }

    @Override
    public EventResponseDto findByEventNameOnly(String event) {
        return eventMapper.toEventResponseDto(eventDao.findByEventName(event));
    }

    @Override
    public EventResponseDto updateEditable(UUID id, boolean editable) {
        int res = eventDao.updateEditable(id, editable);
        if (res==1){
            return eventMapper.toEventResponseDto(eventDao.findById(id));
        }else{
            return null;
        }
    }

    @Override
    public EventResponseDto findById(UUID id) {
        return eventMapper.toEventResponseDto(eventDao.findById(id));
    }

//    @Override
//    public List<SmsTemplateResponseDto> findAllSms(String type) {
//        return eventMapper.toSmsTemplateDtoList(eventDao.findAllByType(type));
//    }
}
