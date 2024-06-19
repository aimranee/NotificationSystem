package com.adria.notification.dao.impl;

import com.adria.notification.dao.IEventDao;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
//import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
//import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.mappers.EventMapper;
import com.adria.notification.models.entities.Event;
import com.adria.notification.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IEventDaoImpl implements IEventDao {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public int updateEditable(UUID id, boolean editable) {
        return eventRepository.updateEditableById(id, editable);
    }

    @Override
    public Event findById(UUID id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public List<Event> findAllEventNames() {
        return eventRepository.findAll();
    }

    @Override
    public Event saveEmail(EmailTemplateRequestDto emailTemplate) {
        return eventRepository.save(eventMapper.toEmailTemplateEntity(emailTemplate));
    }

//    @Override
//    public Template saveSms(SmsTemplateRequestDto smsTemplate) {
//        return templateRepository.save(templateMapper.toSmsTemplateEntity(smsTemplate));
//    }

    @Override
    public Event updateEmail(EmailTemplateRequestDto emailTemplate) {
        return eventRepository.save(eventMapper.toEmailTemplateEntity(emailTemplate));
    }

    @Override
    public List<Event> findAllByNotificationType(String type) {
        return eventRepository.findAllByNotificationType(type);
    }

//    @Override
//    public Template updateSms(SmsTemplateRequestDto smsTemplate) {
//        return templateRepository.save(templateMapper.toSmsTemplateEntity(smsTemplate));
//    }



    @Override
    public void deleteEmail(EmailTemplateResponseDto emailTemplate) {
        eventRepository.delete(eventMapper.toEmailTemplateEntity(emailTemplate));
    }

    @Override
    public Event findByEventName(String event) {
        return eventRepository.findByEventName(event);
    }

//    @Override
//    public void deleteSms(SmsTemplateResponseDto smsTemplate) {
//        templateRepository.delete(templateMapper.toSmsTemplateEntity(smsTemplate));
//    }
}
