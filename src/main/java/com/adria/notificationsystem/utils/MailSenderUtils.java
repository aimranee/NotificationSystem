package com.adria.notificationsystem.utils;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
public class MailSenderUtils {

    private final JavaMailSender javaMailSender;

    @Autowired
    private RecipientRepository recipientRepository;
    private final SpringTemplateEngine templateEngine;

    public MailSenderUtils(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public String mailSending(NotificationSys notification, String sender) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
        Recipient recipient = recipientRepository.findById(notification.getId());

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(recipient.getEmail());
            mimeMessageHelper.setSubject(notification.getSubject());

            Context context = new Context();
            context.setVariables(setVariablesOnEmailTemplate(notification));
            String htmlContent = templateEngine.process("emailTemplate", context);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

            return "Mail Sent Successfully";
        } catch (MessagingException e ) {
            throw new RuntimeException("Error while sending email!!", e);
        }
    }

    private Map<String, Object> setVariablesOnEmailTemplate(NotificationSys notificationSys) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("recipientName", notificationSys.getRecipient().toString());
        templateVariables.put("requestId", 100);
        templateVariables.put("requestDate", LocalDateTime.now());
        templateVariables.put("senderName", "PSO Team, TechnoNext");
        return templateVariables;
    }

}
