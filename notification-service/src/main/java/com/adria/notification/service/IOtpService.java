package com.adria.notification.service;

public interface IOtpService {

    String generateRandomOtp(int length);

    boolean validateOtp(String email, String otp);

    String getOtpMessage(String email, String otp);

}
