package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.request.NotificationDetailDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.NotificationResponseDto;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.mapper.NotificationMapper;
import com.adria.notificationsystem.mapper.RecipientMapper;
import com.adria.notificationsystem.service.EventService;
import com.adria.notificationsystem.service.NotificationService;
import com.adria.notificationsystem.service.RecipientService;
import com.adria.notificationsystem.utils.EmailSenderUtils;
import com.adria.notificationsystem.utils.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service(NotificationType.EMAIL)
@RequiredArgsConstructor
public class EmailServiceImpl implements NotificationService {

    private final EmailSenderUtils emailSenderUtils;

    @Value("${mail.username}")
    private String sender;

    private final EventService eventService;

    private final RecipientService recipientService;

    private final NotificationMapper notificationMapper;
    private final EventMapper eventMapper;
    private final RecipientMapper recipientMapper;

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotification(NotificationRequestDto requestDTO) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        NotificationDetailDto notificationDetailDto = new NotificationDetailDto();
        try {
            EventRequestDto eventDto = eventMapper.toDto(eventService.findByEventType(requestDTO.getEventType()));
            RecipientRequestDto recipientDto = recipientMapper.toDto(recipientService.findByEmail(requestDTO.getEmailRecipient()));
//            if (recipient == null)
//                recipient = recipientService.save(new RecipientRequestDto(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));
            notificationDetailDto.setRecipientDto(recipientDto);
            notificationDetailDto.setEventDto(eventDto);
            if (requestDTO.getEventType() == "OTP")
                notificationDetailDto.setMessage(requestDTO.getMessage());
            emailSenderUtils.emailSending(notificationDetailDto, sender);
            notificationResponseDto.setResult("done");
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }

//    @Override
//    public ResponseEntity<NotificationResponseDto> sendNotificationWithFiles(MultipartFile file, NotificationRequestDto requestDto) {
//        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
//        try {
//            FileUtil.isValid(file);
//            NotificationSys notificationSys = notificationMapper.toEntity(requestDto);
//            Event event = eventService.findByEventType(requestDto.getEventType());
//            Recipient recipient = recipientService.findByEmail(requestDto.getEmailRecipient());
//            String result = emailSenderUtils.mailSendingWithAttachment(requestDto, sender, file);
//            return ResponseEntity.ok(responseDto);
//        } catch (MailException e) {
//            responseDto.setResult("not done!");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDto);
//        }
//
//    }
}
