package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import com.adria.notificationsystem.dto.response.NotificationResponseDto;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.mapper.NotificationMapper;
import com.adria.notificationsystem.mapper.RecipientMapper;
import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.models.Recipient;
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
        try {
            NotificationSys notificationSys = notificationMapper.toEntity(requestDTO);
            Event event = eventService.findByEventType(requestDTO.getEventType());
            Recipient recipient = recipientService.findByEmail(requestDTO.getEmailRecipient());
//            if (recipient == null)
//                recipient = recipientService.save(new RecipientRequestDto(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));
//            if (requestDTO.getEventType() == "OTP")
//                event.setMessage(requestDTO.getMessage());
            notificationSys.setEvent(event);
            notificationSys.setRecipient(recipient);
            emailSenderUtils.emailSending(notificationSys, sender);
            notificationResponseDto.setResult("done");
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }
}
