package com.adria.notificationsystem.utils;

import com.adria.notificationsystem.dto.request.NotificationDetailDto;
import com.adria.notificationsystem.model.NotificationSys;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmailSenderUtils {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public String emailSending(NotificationDetailDto notificationDto, String sender) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(notificationDto.getRecipientDto().getEmail());
            mimeMessageHelper.setSubject(notificationDto.getEventDto().getSubject());

            Context context = new Context();
            context.setVariables(setVariablesOnEmailTemplate(notificationDto));
            String htmlContent = templateEngine.process("emailTemplate", context);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

            return "Email Sent Successfully";
        } catch (MessagingException e ) {
            throw new RuntimeException("Error while sending email!!", e);
        }
    }

//    public String mailSendingWithAttachment(NotificationSys notificationSys, String sender, MultipartFile file) {
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper;
//
//        try {
//            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//
//            mimeMessageHelper.setFrom(sender);
//            mimeMessageHelper.setTo(notificationSys.getRecipient().getEmail());
//            mimeMessageHelper.setSubject(notificationSys.getEvent().getSubject());
//
//            Context context = new Context();
//            context.setVariables(setVariablesOnEmailTemplate(notificationSys));
//            String htmlContent = templateEngine.process("emailTemplate", context);
//            mimeMessageHelper.setText(htmlContent, true);
//
//            mimeMessageHelper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file);
//            javaMailSender.send(mimeMessage);
//
//            return "Mail Sent Successfully";
//        } catch (MessagingException e ) {
//            throw new RuntimeException ("Error while sending email!!", e);
//        }
//    }

    private Map<String, Object> setVariablesOnEmailTemplate(NotificationDetailDto notificationDto) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("recipientLastName", notificationDto.getRecipientDto().getLastName());
        templateVariables.put("recipientFirstName", notificationDto.getRecipientDto().getFirstName());
        templateVariables.put("requestId", 100);
        templateVariables.put("requestDate", LocalDateTime.now());
        templateVariables.put("senderName", "Adria Business & Technology");
        templateVariables.put("message", notificationDto.getEventDto().getMessage());
        return templateVariables;
    }


}
