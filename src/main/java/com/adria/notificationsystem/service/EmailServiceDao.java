package com.adria.notificationsystem.service;

import com.adria.notificationsystem.models.NotificationSys;
import com.adria.notificationsystem.responce.EmailResponse;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface EmailServiceDao {
    CompletableFuture<ResponseEntity<EmailResponse>> sendAsyncEmail(NotificationSys notfication);

    ResponseEntity<String> sendSyncEmail(NotificationSys notfication);

}
