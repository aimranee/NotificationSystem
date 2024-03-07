package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.responce.EmailResponse;
import com.adria.notificationsystem.service.EmailServiceDao;
import com.adria.notificationsystem.utils.EmailSenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailServiceImpl implements EmailServiceDao {

    private final EmailSenderUtils emailSenderUtils;
    @Value("${mail.username}")
    private String sender;

    @Autowired
    public EmailServiceImpl(EmailSenderUtils emailSenderUtils) {
        this.emailSenderUtils = emailSenderUtils;
    }

    @Override
    public CompletableFuture<ResponseEntity<EmailResponse>> sendAsyncEmail(NotificationSys notfications) {
        return CompletableFuture.supplyAsync(() -> {
            EmailResponse emailResponse = new EmailResponse();
            try {
                emailSenderUtils.emailSending(notfications,sender);
                emailResponse.setResult("done");

                return ResponseEntity.ok(emailResponse);
            } catch (MailException e) {
                emailResponse.setResult("not done!");

                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailResponse);
            }

        });
    }

    @Override
    public ResponseEntity<String> sendSyncEmail(NotificationSys notfication) {
        return null;
    }
}
