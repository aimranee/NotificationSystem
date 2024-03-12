package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import com.adria.notificationsystem.dto.response.EventResponseDto;
import com.adria.notificationsystem.mapper.EmailMapper;
import com.adria.notificationsystem.mapper.EventMapper;
import com.adria.notificationsystem.models.Email;
import com.adria.notificationsystem.models.Event;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.EventRepository;
import com.adria.notificationsystem.repository.RecipientRepository;
import com.adria.notificationsystem.service.EmailService;
import com.adria.notificationsystem.service.EventService;
import com.adria.notificationsystem.utils.EmailSenderUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailSenderUtils emailSenderUtils;

    @Value("${mail.username}")
    private String sender;

    private final EventService eventService;

    private final RecipientRepository recipientRepository;

    private final EmailMapper emailMapper;
    private final EventMapper eventMapper;

    @Override
    public CompletableFuture<ResponseEntity<EmailResponseDto>> sendEmail(EmailRequestDto requestDTO) {
        return CompletableFuture.supplyAsync(() -> {
            EmailResponseDto emailResponseDto = new EmailResponseDto();
            try {
                Email email = emailMapper.toEntity(requestDTO);
                Event event = eventService.findByEventType(requestDTO.getEventType());
                Recipient recipient = recipientRepository.findByEmail(requestDTO.getEmailRecipient());
                if (recipient == null)
                    recipient = recipientRepository.save(new Recipient(requestDTO.getFirstName(), requestDTO.getLastName(), requestDTO.getEmailRecipient(), null, null));
                if (requestDTO.getEventType() == "OTP")
                    event.setMessage(requestDTO.getMessage());
                email.setEvent(event);
                email.setRecipient(recipient);
                emailSenderUtils.emailSending(email, sender);
                emailResponseDto.setResult("done");
                return ResponseEntity.ok(emailResponseDto);
            } catch (MailException e) {
                emailResponseDto.setResult("not done!");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponseDto);
            }

        });
    }

}