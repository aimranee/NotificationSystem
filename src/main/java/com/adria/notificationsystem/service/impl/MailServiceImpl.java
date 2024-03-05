package com.adria.notificationsystem.service.impl;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.responce.EmailResponse;
import com.adria.notificationsystem.service.MailServiceDao;
import com.adria.notificationsystem.utils.MailSenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class MailServiceImpl implements MailServiceDao {

    private final MailSenderUtils mailSenderUtils;
    @Value("${mail.username}")
    private String sender;

    @Autowired
    public MailServiceImpl(MailSenderUtils mailSenderUtils) {
        this.mailSenderUtils = mailSenderUtils;
    }

    @Override
    public CompletableFuture<ResponseEntity<EmailResponse>> sendAsyncEmail(NotificationSys notfications) {
        return CompletableFuture.supplyAsync(() -> {
            EmailResponse emailResponse = new EmailResponse();
            try {
                mailSenderUtils.mailSending(notfications,sender);
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
