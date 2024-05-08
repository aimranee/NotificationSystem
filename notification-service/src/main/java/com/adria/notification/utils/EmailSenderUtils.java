package com.adria.notification.utils;

import com.adria.notification.dto.request.VariablesRequestDto;
import com.adria.notification.dto.request.notification.NotificationDetailDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.exceptions.EmailSendingException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class EmailSenderUtils {

    private final JavaMailSender javaMailSender;

    public String emailSending(EmailTemplateRequestDto templateDto, String recipient, List<VariablesRequestDto> requestVariables){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(templateDto.getEmailProvider().getMailUsername());
            messageHelper.setTo(recipient);
            messageHelper.setSubject(templateDto.getSubject());

            Map<String, Object> templateVariables = setVariablesOnEmailTemplate(requestVariables);
            String processedHtmlContent = processTemplate(templateDto.getEmailRenderedHtml(), templateVariables);
            messageHelper.setText(processedHtmlContent, true);

            javaMailSender.send(mimeMessage);

            return "Email Sent Successfully";
        } catch (MessagingException e ) {
            throw new EmailSendingException("Error while sending email!!", e);
        }
    }


    public String mailSendingWithAttachment(EmailTemplateRequestDto templateDto, String recipient, List<MultipartFile> files, List<VariablesRequestDto> requestVariables) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(templateDto.getEmailProvider().getMailUsername());
            messageHelper.setTo(recipient);
            messageHelper.setSubject(templateDto.getSubject());

            Map<String, Object> templateVariables = setVariablesOnEmailTemplate(requestVariables);
            String processedHtmlContent = processTemplate(templateDto.getEmailRenderedHtml(), templateVariables);
            messageHelper.setText(processedHtmlContent, true);

            for (MultipartFile file : files) {
                String originalFilename = Objects.requireNonNull(file.getOriginalFilename());
                messageHelper.addAttachment(originalFilename, file);
            }


            javaMailSender.send(mimeMessage);

            return "Mail Sent Successfully";
        } catch (MessagingException e ) {
            throw new RuntimeException ("Error while sending email!!", e);
        }
    }

    private Map<String, Object> setVariablesOnEmailTemplate(List<VariablesRequestDto> requestVariables) {
        Map<String, Object> templateVariables = new HashMap<>();
        for (VariablesRequestDto variable : requestVariables) {
            String name = variable.getName();
            String value = variable.getValue();
            templateVariables.put(name, value);
        }
        return templateVariables;
    }

    private String processTemplate(String htmlContent, Map<String, Object> variables) {
        String processedContent = htmlContent;
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            String variableName = entry.getKey();
            Object variableValue = entry.getValue();
            String placeholder = "\\[\\[\\$\\{" + variableName + "\\}\\]\\]";
            processedContent = processedContent.replaceAll(placeholder, variableValue.toString());
        }
        return processedContent;
    }


}
