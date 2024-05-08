package com.adria.notification.services.impl;

import com.adria.notification.dao.IEmailProviderDao;
import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.response.NotificationResponseDto;
import com.adria.notification.mappers.EmailProviderMapper;
import com.adria.notification.mappers.RecipientMapper;
import com.adria.notification.services.INotificationService;
import com.adria.notification.dao.IRecipientDao;
import com.adria.notification.services.IEventService;
import com.adria.notification.utils.EmailSenderUtils;
import com.adria.notification.utils.FileUtils;
import com.adria.notification.utils.NotificationType;
import com.adria.notification.utils.ValidationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service(NotificationType.EMAIL)
@RequiredArgsConstructor
public class EmailServiceImpl implements INotificationService<NotificationResponseDto> {

    private final IRecipientDao recipientService;
    private final IEmailProviderDao providerService;
    private final EmailProviderMapper providerMapper;
    private final RecipientMapper recipientMapper;
    private final EmailSenderUtils emailSenderUtils;
    //    private final IOtpService otpService;
    private final IEventService templateService;

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotification(NotificationRequestDto requestDto) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();

        try {

            for (EventRequestDto eventRequestDto : requestDto.getEvent()){

                EmailTemplateRequestDto templateDto = templateService.findByEventName(eventRequestDto.getEventName());
                if (templateDto.getEmailProvider() == null) {
                    templateDto.setEmailProvider(providerMapper.toDto(providerService.getEmailProviderByName("primary")));
                }
                RecipientRequestDto recipientDto = recipientMapper.toDto(recipientService.findByEmail(requestDto.getEmailRecipient()));
//            if (recipient == null)
//                recipient = recipientService.save(new RecipientRequestDto(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));

//            if ("OTP".equals(requestDto.getEventName())){
//                String otp = otpService.generateRandomOtp(6);
//                String message = otpService.getOtpMessage(recipientDto.getEmail(), otp);
////                notificationDetailDto.setMessage(message);
//            }else{
////                notificationDetailDto.setMessage(eventDto.getMessage());
//            }
                if (!ValidationUtils.validateVariables(templateDto.getVariables(), eventRequestDto.getVariables())) {

                    notificationResponseDto.setResult("Variables validation failed");
                    return ResponseEntity.badRequest().body(notificationResponseDto);
                }
                emailSenderUtils.emailSending(templateDto, recipientDto.getEmail(), eventRequestDto.getVariables());
            }
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

        try {

            for (EventRequestDto eventRequestDto : requestDto.getEvent()){

                EmailTemplateRequestDto templateDto = templateService.findByEventName(eventRequestDto.getEventName());
                for (MultipartFile file : files)
                    FileUtils.isValid(file);
                if (templateDto.getEmailProvider() == null) {
                    templateDto.setEmailProvider(providerMapper.toDto(providerService.getEmailProviderByName("primary")));
                }
                RecipientRequestDto recipientDto = recipientMapper.toDto(recipientService.findByEmail(requestDto.getEmailRecipient()));

//            if (requestDto.getEventName()=="OTP"){
//                String otp = otpService.generateRandomOtp(6);
//                String message = otpService.getOtpMessage(recipient.getEmail(), otp);
////                notificationDetailDto.setMessage(message);
//            }else{
////                notificationDetailDto.setMessage(event.getMessage());
//            }

                if (!ValidationUtils.validateVariables(templateDto.getVariables(), eventRequestDto.getVariables())) {

                    notificationResponseDto.setResult("Variables validation failed");
                    return ResponseEntity.badRequest().body(notificationResponseDto);
                }

                emailSenderUtils.mailSendingWithAttachment(templateDto, recipientDto.getEmail(), files, eventRequestDto.getVariables());
            }
            notificationResponseDto.setResult("done");
            return ResponseEntity.ok(notificationResponseDto);
        } catch (MailException e) {
            notificationResponseDto.setResult("not done!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(notificationResponseDto);
        }
    }
}
