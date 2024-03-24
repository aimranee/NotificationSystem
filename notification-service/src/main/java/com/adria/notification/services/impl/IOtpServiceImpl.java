package com.adria.notification.services.impl;

import com.adria.notification.dto.request.OtpRequestDto;
import com.adria.notification.services.IOtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class IOtpServiceImpl implements IOtpService {
    private final Map<String, OtpRequestDto> otpCache = new ConcurrentHashMap<>();

    @Override
    public String generateRandomOtp(int length) {
        String numbers = "0123456789";
        Random randomObject = new Random();
        char[] otp = new char[length];
        for (int i = 0; i < length; i++) {
            otp[i] = numbers.charAt(randomObject.nextInt(10)); // cast to character
        }
        return new String(otp);
    }

    @Override
    public boolean validateOtp(String email, String otp) {
        OtpRequestDto otpData = otpCache.get(email);
        if (otpData != null && Objects.equals(otpData.getOtp(), otp)) {
            if (System.currentTimeMillis() - otpData.getTimestamp() <= 300000) {
                otpCache.remove(email);
                return true;
            }
        }
        return false;
    }

    @Override
    public String getOtpMessage(String email, String otp) {
        otpCache.put(email, new OtpRequestDto(otp, System.currentTimeMillis()));
        String message = "Dear! \n Your OTP for <some thing> is " + otp
                + "\n This otp will be invalid after 5 minutes.";

//        NotificationRequestDto requestDto = new NotificationRequestDto();
//        requestDto.setEmailRecipient(email);
//        requestDto.setMessage(message);
//        requestDto.setEventType("OTP");

        return message;
    }
}
