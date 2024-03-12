package com.adria.notificationsystem.controller;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import com.adria.notificationsystem.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    private final EmailService emailService;

    @Autowired
    public NotificationController(EmailService emailServiceDao) {
        this.emailService = emailServiceDao;
    }

    @PostMapping("/send-email")
    public CompletableFuture<ResponseEntity<EmailResponseDto>> sendEmail(@Valid @RequestBody EmailRequestDto requestDTO) {
        return emailService.sendEmail(requestDTO);
    }

}
