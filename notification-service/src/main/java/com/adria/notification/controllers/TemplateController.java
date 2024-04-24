package com.adria.notification.controllers;

import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.request.template.SmsTemplateRequestDto;
import com.adria.notification.dto.response.template.EmailTemplateResponseDto;
import com.adria.notification.dto.response.template.SmsTemplateResponseDto;
import com.adria.notification.services.ITemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/templates")
public class TemplateController {
    final private ITemplateService templateService;

    @PostMapping("/saveEmail")
    public ResponseEntity<EmailTemplateRequestDto> saveEmail(@Valid @RequestBody EmailTemplateRequestDto emailTemplate){
        return ResponseEntity.ok().body(templateService.saveEmail(emailTemplate));
    }

    @PostMapping("/updateEmail")
    public ResponseEntity<EmailTemplateRequestDto> updateEmail(@Valid @RequestBody EmailTemplateRequestDto emailTemplate){
        return ResponseEntity.ok().body(templateService.updateEmail(emailTemplate));
    }

    @PostMapping("/deleteEmail")
    public void deleteEmail(@Valid @RequestBody EmailTemplateResponseDto emailTemplate){
        templateService.deleteEmail(emailTemplate);
    }

    @PostMapping("/saveSms")
    public ResponseEntity<SmsTemplateRequestDto> saveSms(@Valid @RequestBody SmsTemplateRequestDto smsTemplate){
        return ResponseEntity.ok().body(templateService.saveSms(smsTemplate));
    }

    @PostMapping("/updateSms")
    public ResponseEntity<SmsTemplateRequestDto> updateSms(@Valid @RequestBody SmsTemplateRequestDto smsTemplate){
        return ResponseEntity.ok().body(templateService.updateSms(smsTemplate));
    }

    @PostMapping("/deleteSms")
    public void deleteSms(@Valid @RequestBody SmsTemplateResponseDto smsTemplate){
        templateService.deleteSms(smsTemplate);
    }

    @GetMapping("/findAllEmail")
    public ResponseEntity<List<EmailTemplateResponseDto>> findAllEmail(@RequestParam String type){
        return ResponseEntity.ok().body(templateService.findAllEmail(type));
    }

    @GetMapping("/findAllSms")
    public ResponseEntity<List<SmsTemplateResponseDto>> findAllSms(@RequestParam String type){
        return ResponseEntity.ok().body(templateService.findAllSms(type));
    }
}
