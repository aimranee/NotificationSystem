package com.adria.notification.utils;

import com.adria.notification.dto.request.UrlRequestDto;
import com.adria.notification.dto.request.VariablesRequestDto;
import com.adria.notification.dto.request.template.EmailTemplateRequestDto;
import com.adria.notification.dto.response.UrlResponseDto;
import com.adria.notification.exceptions.EmailSendingException;
import com.adria.notification.services.IUrlService;
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
    private final IUrlService urlService;

    public String emailSending(EmailTemplateRequestDto templateDto, String recipient, List<VariablesRequestDto> requestVariables){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper;

        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(templateDto.getEmailProvider().getMailUsername());
            messageHelper.setTo(recipient);
            messageHelper.setSubject(templateDto.getSubject());

            Map<String, Object> templateVariables = setVariablesOnEmailTemplate(requestVariables);
            String processedHtmlContent = processTemplate(templateDto.getEmailRenderedHtml(), templateVariables, templateDto.getClientAppId());
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
            String processedHtmlContent = processTemplate(templateDto.getEmailRenderedHtml(), templateVariables, templateDto.getClientAppId());
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

    private String processTemplate(String htmlContent, Map<String, Object> variables, String clientAppId) {
        String processedContent = htmlContent;
        String gatewayUrl = "http://localhost:8888/urlshortening-service/";
        for (Map.Entry<String, Object> entry : variables.entrySet()) {
            String variableName = entry.getKey();
            Object variableValue = entry.getValue();
            String placeholder = "\\[\\[\\$\\{" + variableName + "\\}\\]\\]";
            if (ValidationUtils.isLink(variableValue.toString())) {
                UrlRequestDto urlRequestDto = new UrlRequestDto(variableValue.toString(), clientAppId);
                UrlResponseDto urlResponseDto = urlService.generateShortLink(urlRequestDto).getBody();
                String fullLink = gatewayUrl + urlResponseDto.getShortLink();
                String anchorTag = "<a href=\"" + fullLink + "\">" + fullLink + "</a>";
                processedContent = processedContent.replaceAll(placeholder, anchorTag);
            } else {
                processedContent = processedContent.replaceAll(placeholder, variableValue.toString());
            }
        }
        return processedContent;
    }

}
