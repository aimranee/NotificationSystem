package com.adria.notification.controllers;

import com.adria.notification.dto.request.event.UpdateEventDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.response.event.EventResponseDto;
import com.adria.notification.dto.response.event.EventSimpleResponseDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {
    final private IEventService templateService;

    @PostMapping("/saveEmail")
    public ResponseEntity<EmailTemplateRequestDto> saveEmail(@Valid @RequestBody EmailTemplateRequestDto emailTemplate){
        return ResponseEntity.ok().body(templateService.saveEmail(emailTemplate));
    }

    @PutMapping("/updateEmail")
    public ResponseEntity<EmailTemplateRequestDto> updateEmail(@Valid @RequestBody EmailTemplateRequestDto emailTemplate){
        return ResponseEntity.ok().body(templateService.updateEmail(emailTemplate));
    }

    @PostMapping("/deleteEmail")
    public void deleteEmail(@Valid @RequestBody EmailTemplateResponseDto emailTemplate){
        templateService.deleteEmail(emailTemplate);
    }

    @PutMapping("/updateEditable")
    public EventResponseDto updateEditable(@Valid @RequestBody UpdateEventDto event){
        return templateService.updateEditable(event.getId(), event.isEditable());
    }

//    @PostMapping("/saveSms")
//    public ResponseEntity<SmsTemplateRequestDto> saveSms(@Valid @RequestBody SmsTemplateRequestDto smsTemplate){
//        return ResponseEntity.ok().body(templateService.saveSms(smsTemplate));
//    }

//    @PostMapping("/updateSms")
//    public ResponseEntity<SmsTemplateRequestDto> updateSms(@Valid @RequestBody SmsTemplateRequestDto smsTemplate){
//        return ResponseEntity.ok().body(templateService.updateSms(smsTemplate));
//    }

//    @PostMapping("/deleteSms")
//    public void deleteSms(@Valid @RequestBody SmsTemplateResponseDto smsTemplate){
//        templateService.deleteSms(smsTemplate);
//    }

    @GetMapping("/findAllEmail/{appId}")
    public ResponseEntity<List<EmailTemplateResponseDto>> findAllEmail(@PathVariable String appId){
        return ResponseEntity.ok().body(templateService.findAllEmail("email", appId));
    }

    @GetMapping("/findAllEventNames")
    public ResponseEntity<List<EventSimpleResponseDto>> findAllEventNames(){
        return ResponseEntity.ok().body(templateService.findAllEventNames());
    }

//    @GetMapping("/find/{event}/{type}")
//    public ResponseEntity<EmailTemplateRequestDto> findByEventAndType(@PathVariable String type, @PathVariable String event){
//        return ResponseEntity.ok().body(templateService.findByTypeAndEventName(type, event));
//    }

//    @GetMapping("/findAllSms")
//    public ResponseEntity<List<SmsTemplateResponseDto>> findAllSms(){
//        return ResponseEntity.ok().body(templateService.findAllSms("sms"));
//    }
}
