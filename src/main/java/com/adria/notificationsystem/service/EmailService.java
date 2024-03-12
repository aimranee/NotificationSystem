package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface EmailService {

    CompletableFuture<ResponseEntity<EmailResponseDto>> sendEmail(EmailRequestDto requestDTO);

}
