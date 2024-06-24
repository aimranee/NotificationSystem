package com.adria.notification.services.impl;

import com.adria.notification.dao.IEmailProviderDao;
import com.adria.notification.dto.request.TokenRequestDto;
import com.adria.notification.dto.request.UrlRequestDto;
import com.adria.notification.dto.request.VariablesRequestDto;
import com.adria.notification.dto.request.emailProvider.SaveEmailProviderRequestDTO;
import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.dto.request.RecipientRequestDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.response.NotificationResponseDto;
import com.adria.notification.dto.response.UrlResponseDto;
import com.adria.notification.mappers.EmailProviderMapper;
import com.adria.notification.mappers.RecipientMapper;
import com.adria.notification.models.entities.EmailProvider;
import com.adria.notification.models.entities.PreferenceToken;
import com.adria.notification.models.entities.Recipient;
import com.adria.notification.repositories.PreferenceTokenRepository;
import com.adria.notification.services.IEmailProviderService;
import com.adria.notification.services.INotificationService;
import com.adria.notification.dao.IRecipientDao;
import com.adria.notification.services.IEventService;
import com.adria.notification.services.IUrlService;
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

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service(NotificationType.EMAIL)
@RequiredArgsConstructor
public class EmailServiceImpl implements INotificationService<NotificationResponseDto> {

    private final IRecipientDao recipientService;
    private final IEmailProviderService providerService;
    private final EmailProviderMapper providerMapper;
    private final RecipientMapper recipientMapper;
    private final EmailSenderUtils emailSenderUtils;
    //    private final IOtpService otpService;
    private final IEventService templateService;
    private final PreferenceTokenRepository tokenRepository;
    private final IUrlService urlService;

    private static final long TOKEN_EXPIRATION_HOURS = 24;

    @Override
    public ResponseEntity<NotificationResponseDto> sendNotification(NotificationRequestDto requestDto) {
        NotificationResponseDto notificationResponseDto = new NotificationResponseDto();

        try {
            Recipient recipient;
            RecipientRequestDto recipientDto;
            if (!recipientService.existsByEmail(requestDto.getEmailRecipient())) {
                // Create new recipient
                recipientDto = new RecipientRequestDto();
                recipientDto.setEmail(requestDto.getEmailRecipient());
                recipientDto.setPhone(requestDto.getPhoneRecipient()); // Assume phoneRecipient is a field in requestDto
                recipient = recipientService.save(recipientDto);
            } else {
                recipient = recipientService.findByEmail(requestDto.getEmailRecipient());
                recipientDto = recipientMapper.toDto(recipient);
            }

            PreferenceToken preferenceToken = tokenRepository.findByRecipient(recipient);
            if (preferenceToken == null || isTokenExpired(preferenceToken)) {
                // Generate new token
                String token = generateToken();
                if (preferenceToken == null) {
                    preferenceToken = new PreferenceToken();
                    preferenceToken.setRecipient(recipient);
                }
                preferenceToken.setToken(token);
                preferenceToken.setExpirationDate(LocalDateTime.now().plusHours(TOKEN_EXPIRATION_HOURS));
                tokenRepository.save(preferenceToken);

                // Update token in recipient DTO
                TokenRequestDto tokenDto = new TokenRequestDto();
                tokenDto.setToken(token);
                tokenDto.setExpirationDate(preferenceToken.getExpirationDate());
            }

            // Short link
            String preferencesLink = "http://localhost:3000/preferences?token=" + preferenceToken.getToken();
            String gatewayUrl = "http://localhost:8888/urlshortening-service/";
            UrlRequestDto urlRequestDto = new UrlRequestDto(preferencesLink, requestDto.getClientAppId());
            UrlResponseDto urlResponseDto = urlService.generateShortLink(urlRequestDto).getBody();
            String fullLink = gatewayUrl + urlResponseDto.getShortLink();

            for (EventRequestDto eventRequestDto : requestDto.getEvent()) {

                eventRequestDto.getVariables().add(new VariablesRequestDto("PREFERENCES_LINK", fullLink));

                EmailTemplateRequestDto templateDto = templateService.findByEventNameAndAppId(eventRequestDto.getEventName(), requestDto.getClientAppId());
                if (templateDto.getEmailProvider() == null) {
                    if (!providerService.existsByName("primary")) {
                        templateDto.setEmailProvider(providerService.saveEmailProvider(new SaveEmailProviderRequestDTO("primary", "smtp.gmail.com", "587", "instaaimrane@gmail.com", "vqypgfgwqexsumxp", "smtp", true, true, "smtp.gmail.com", requestDto.getClientAppId())));
                    } else {
                        templateDto.setEmailProvider(providerService.getEmailProviderByName("primary"));
                    }
                }

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

            Recipient recipient;
            RecipientRequestDto recipientDto;
            if (!recipientService.existsByEmail(requestDto.getEmailRecipient())) {
                // Create new recipient
                recipientDto = new RecipientRequestDto();
                recipientDto.setEmail(requestDto.getEmailRecipient());
                recipientDto.setPhone(requestDto.getPhoneRecipient()); // Assume phoneRecipient is a field in requestDto
                recipient = recipientService.save(recipientDto);
            } else {
                recipient = recipientService.findByEmail(requestDto.getEmailRecipient());
                recipientDto = recipientMapper.toDto(recipient);
            }

            PreferenceToken preferenceToken = tokenRepository.findByRecipient(recipient);
            if (preferenceToken == null || isTokenExpired(preferenceToken)) {
                // Generate new token
                String token = generateToken();
                if (preferenceToken == null) {
                    preferenceToken = new PreferenceToken();
                    preferenceToken.setRecipient(recipient);
                }
                preferenceToken.setToken(token);
                preferenceToken.setExpirationDate(LocalDateTime.now().plusHours(TOKEN_EXPIRATION_HOURS));
                tokenRepository.save(preferenceToken);

                // Update token in recipient DTO
                TokenRequestDto tokenDto = new TokenRequestDto();
                tokenDto.setToken(token);
                tokenDto.setExpirationDate(preferenceToken.getExpirationDate());
            }

            // Short link
            String preferencesLink = "http://localhost:3000/preferences?token=" + preferenceToken.getToken();
            String gatewayUrl = "http://localhost:8888/urlshortening-service/";
            UrlRequestDto urlRequestDto = new UrlRequestDto(preferencesLink, requestDto.getClientAppId());
            UrlResponseDto urlResponseDto = urlService.generateShortLink(urlRequestDto).getBody();
            String fullLink = gatewayUrl + urlResponseDto.getShortLink();

            for (EventRequestDto eventRequestDto : requestDto.getEvent()) {

                eventRequestDto.getVariables().add(new VariablesRequestDto("PREFERENCES_LINK", fullLink));

                EmailTemplateRequestDto templateDto = templateService.findByEventNameAndAppId(eventRequestDto.getEventName(), requestDto.getClientAppId());
                for (MultipartFile file : files)
                    FileUtils.isValid(file);
                if (templateDto.getEmailProvider() == null) {
                    if (!providerService.existsByName("primary")) {
                        templateDto.setEmailProvider(providerService.saveEmailProvider(new SaveEmailProviderRequestDTO("primary", "smtp.gmail.com", "587", "instaaimrane@gmail.com", "vqypgfgwqexsumxp", "smtp", true, true, "smtp.gmail.com", requestDto.getClientAppId())));
                    } else {
                        templateDto.setEmailProvider(providerService.getEmailProviderByName("primary"));
                    }                }
                eventRequestDto.getVariables().add(new VariablesRequestDto("PREFERENCES_LINK", fullLink));

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

    private boolean isTokenExpired(PreferenceToken token) {
        return token.getExpirationDate().isBefore(LocalDateTime.now());
    }

    public String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }
}
