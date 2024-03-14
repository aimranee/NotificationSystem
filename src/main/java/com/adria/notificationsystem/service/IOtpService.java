package com.adria.notificationsystem.service;

import org.springframework.http.ResponseEntity;

public interface IOtpService {

    String generateRandomOtp(int length);

    boolean validateOtp(String email, String otp);

    String getOtpMessage(String email, String otp);

}
