package com.adria.notification.service.impl;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.request.notification.NotificationDetailDto;
import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.dto.response.NotificationResponseDto;
import com.adria.notification.mapper.EventMapper;
import com.adria.notification.mapper.RecipientMapper;
import com.adria.notification.dao.IEventDao;
import com.adria.notification.model.entities.Event;
import com.adria.notification.model.entities.Recipient;
import com.adria.notification.service.INotificationService;
import com.adria.notification.dao.IRecipientDao;
import com.adria.notification.service.IOtpService;
import com.adria.notification.utils.EmailSenderUtils;
import com.adria.notification.utils.FileUtils;
import com.adria.notification.utils.NotificationType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service(NotificationType.EMAIL)
@RequiredArgsConstructor
public class EmailServiceImpl implements INotificationService<NotificationResponseDto> {

    @Value("${mail.username}")
    private String sender;

    private final IEventDao eventService;
    private final IRecipientDao recipientService;
    private final EventMapper eventMapper;
    private final RecipientMapper recipientMapper;
    private final EmailSenderUtils emailSenderUtils;
    private final IOtpService otpService;

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotification(NotificationRequestDto requestDto) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        NotificationDetailDto notificationDetailDto = new NotificationDetailDto();
        try {
            EventRequestDto eventDto = eventMapper.toDto(eventService.findByType(requestDto.getEventType()));
            RecipientRequestDto recipientDto = recipientMapper.toDto(recipientService.findByEmail(requestDto.getEmailRecipient()));
//            if (recipient == null)
//                recipient = recipientService.save(new RecipientRequestDto(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));

            if ("OTP".equals(requestDto.getEventType())){
                String otp = otpService.generateRandomOtp(6);
                String message = otpService.getOtpMessage(recipientDto.getEmail(), otp);
                notificationDetailDto.setMessage(message);
            }else{
                notificationDetailDto.setMessage(eventDto.getMessage());
            }

            notificationDetailDto.setRecipientDto(recipientDto);
            notificationDetailDto.setEventDto(eventDto);
            emailSenderUtils.emailSending(notificationDetailDto, sender);
            notificationResponseDto.setResult("done");
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotificationWithFiles(List<MultipartFile> files, NotificationRequestDto requestDto) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        NotificationDetailDto notificationDetailDto = new NotificationDetailDto();
        try {
            for (MultipartFile file : files)
                FileUtils.isValid(file);

            Event event = eventService.findByType(requestDto.getEventType());
            Recipient recipient = recipientService.findByEmail(requestDto.getEmailRecipient());
            notificationDetailDto.setEventDto(eventMapper.toDto(event));
            notificationDetailDto.setRecipientDto(recipientMapper.toDto(recipient));

            if (requestDto.getEventType()=="OTP"){
                String otp = otpService.generateRandomOtp(6);
                String message = otpService.getOtpMessage(recipient.getEmail(), otp);
                notificationDetailDto.setMessage(message);
            }else{
                notificationDetailDto.setMessage(event.getMessage());
            }

            String result = emailSenderUtils.mailSendingWithAttachment(notificationDetailDto, sender, files);
            notificationResponseDto.setResult(result);
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }
}
