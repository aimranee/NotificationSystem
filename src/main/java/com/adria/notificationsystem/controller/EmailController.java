package com.adria.notificationsystem.controller;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.responce.EmailResponse;
import com.adria.notificationsystem.service.EmailServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/notification")
public class EmailController {
    private final EmailServiceDao emailServiceDao;

    @Autowired
    public EmailController(EmailServiceDao emailServiceDao) {
        this.emailServiceDao = emailServiceDao;
    }

    @PostMapping("/send-async-email")
    public CompletableFuture<ResponseEntity<EmailResponse>> sendEmail(@Valid @RequestBody NotificationSys notification) {
        return emailServiceDao.sendAsyncEmail(notification);
    }

    @PostMapping("/send-sync-email")
    public ResponseEntity<String> sendSyncEmail(@Valid @RequestBody NotificationSys notification) {
        return emailServiceDao.sendSyncEmail(notification);
    }

}
