package com.adria.notificationsystem.controller;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.responce.EmailResponse;
import com.adria.notificationsystem.service.MailServiceDao;
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
public class MailController {
    private final MailServiceDao mailServiceDao;

    @Autowired
    public MailController(MailServiceDao mailServiceDao) {
        this.mailServiceDao = mailServiceDao;
    }

    @PostMapping("/send-async-mail")
    public CompletableFuture<ResponseEntity<EmailResponse>> sendEmail(@Valid @RequestBody NotificationSys notification) {
        return mailServiceDao.sendAsyncEmail(notification);
    }

    @PostMapping("/send-sync-mail")
    public ResponseEntity<String> sendSyncEmail(@Valid @RequestBody NotificationSys notification) {
        return mailServiceDao.sendSyncEmail(notification);
    }

}
