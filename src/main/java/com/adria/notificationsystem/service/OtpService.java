package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.response.EmailResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;

public interface OtpService {

    String generateRandomOtp(int length);

    boolean validateOtp(String email, String otp);

    CompletableFuture<ResponseEntity<EmailResponseDto>> sendOtp(String email, String otp);

}
