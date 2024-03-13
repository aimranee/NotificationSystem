package com.adria.notificationsystem.utils;

import com.adria.notificationsystem.models.Email;
import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.RecipientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailSenderUtils {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    public String emailSending(NotificationSys notificationSys, String sender) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(notificationSys.getRecipient().getEmail());
            mimeMessageHelper.setSubject(notificationSys.getEvent().getSubject());

            Context context = new Context();
            context.setVariables(setVariablesOnEmailTemplate(notificationSys));
            String htmlContent = templateEngine.process("emailTemplate", context);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

            return "Email Sent Successfully";
        } catch (MessagingException e ) {
            throw new RuntimeException("Error while sending email!!", e);
        }
    }

    private Map<String, Object> setVariablesOnEmailTemplate(NotificationSys notificationSys) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("recipientLastName", notificationSys.getRecipient().getLastName());
        templateVariables.put("recipientFirstName", notificationSys.getRecipient().getFirstName());
        templateVariables.put("requestId", 100);
        templateVariables.put("requestDate", LocalDateTime.now());
        templateVariables.put("senderName", "Adria Business & Technology");
        templateVariables.put("message", notificationSys.getEvent().getMessage());
        return templateVariables;
    }
}
