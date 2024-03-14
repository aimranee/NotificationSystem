package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dto.request.EventRequestDto;
import com.adria.notificationsystem.dto.request.NotificationDetailDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.dto.request.RecipientRequestDto;
import com.adria.notificationsystem.dto.response.NotificationResponseDto;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.mapper.RecipientMapper;
import com.adria.notificationsystem.dao.IEventService;
import com.adria.notificationsystem.model.entities.Event;
import com.adria.notificationsystem.model.entities.Recipient;
import com.adria.notificationsystem.service.INotificationService;
import com.adria.notificationsystem.dao.IRecipientService;
import com.adria.notificationsystem.service.IOtpService;
import com.adria.notificationsystem.utils.EmailSenderUtils;
import com.adria.notificationsystem.utils.FileUtils;
import com.adria.notificationsystem.utils.NotificationType;
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

    private final IEventService eventService;
    private final IRecipientService recipientService;
    private final EventMapper eventMapper;
    private final RecipientMapper recipientMapper;
    private final EmailSenderUtils emailSenderUtils;
    private final IOtpService otpService;

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotification(NotificationRequestDto requestDto) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();
        NotificationDetailDto notificationDetailDto = new NotificationDetailDto();
        try {
            EventRequestDto eventDto = eventMapper.toDto(eventService.findByEventType(requestDto.getEventType()));
            RecipientRequestDto recipientDto = recipientMapper.toDto(recipientService.findByEmail(requestDto.getEmailRecipient()));
//            if (recipient == null)
//                recipient = recipientService.save(new RecipientRequestDto(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));

            if ("OTP".equals(requestDto.getEventType())){
                String otp = otpService.generateRandomOtp(6);
                String message = otpService.getOtpMessage(recipientDto.getEmail(), otp);
                notificationDetailDto.setMessage(message);
            }
            System.err.println("====================>>>>> " + notificationDetailDto.getMessage());

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

            Event event = eventService.findByEventType(requestDto.getEventType());
            Recipient recipient = recipientService.findByEmail(requestDto.getEmailRecipient());
            notificationDetailDto.setEventDto(eventMapper.toDto(event));
            notificationDetailDto.setRecipientDto(recipientMapper.toDto(recipient));

            if (requestDto.getEventType()=="OTP"){
                System.err.println("====================>>>>> " + requestDto.getEmailRecipient());

                String otp = otpService.generateRandomOtp(6);
                System.err.println("====================>>>>> " + otp);

                String message = otpService.getOtpMessage(recipient.getEmail(), otp);
                System.err.println("====================>>>>> " + message);

                notificationDetailDto.setMessage(message);
            }else{
                notificationDetailDto.setMessage(event.getMessage());
            }
            System.err.println(notificationDetailDto.getMessage());
            String result = emailSenderUtils.mailSendingWithAttachment(notificationDetailDto, sender, files);
            notificationResponseDto.setResult(result);
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }
}
