package com.adria.notificationsystem.utils;

import com.adria.notificationsystem.models.Email;
import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.models.Recipient;
import com.adria.notificationsystem.repository.RecipientRepository;
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
public class EmailSenderUtils {

    private final JavaMailSender javaMailSender;

    @Autowired
    private RecipientRepository recipientRepository;
    private final SpringTemplateEngine templateEngine;

    public EmailSenderUtils(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public String emailSending(Email email, String sender) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(email.getRecipient().getEmail());
            mimeMessageHelper.setSubject(email.getEvent().getSubject());

            Context context = new Context();
            context.setVariables(setVariablesOnEmailTemplate(email));
            String htmlContent = templateEngine.process("emailTemplate", context);
            mimeMessageHelper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);

            return "Email Sent Successfully";
        } catch (MessagingException e ) {
            throw new RuntimeException("Error while sending email!!", e);
        }
    }

    private Map<String, Object> setVariablesOnEmailTemplate(Email email) {
        Map<String, Object> templateVariables = new HashMap<>();
        templateVariables.put("recipientLastName", email.getRecipient().getLastName());
        templateVariables.put("recipientFirstName", email.getRecipient().getFirstName());
        templateVariables.put("requestId", 100);
        templateVariables.put("requestDate", LocalDateTime.now());
        templateVariables.put("senderName", "Adria Business & Technology");
        templateVariables.put("message", email.getEvent().getMessage());
        return templateVariables;
    }

}
