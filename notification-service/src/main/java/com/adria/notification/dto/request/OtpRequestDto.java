package com.adria.notification.dto.request;

import lombok.Getter;

@Getter
public class OtpRequestDto {

    private final String otp;

    private final long timestamp;

    public OtpRequestDto(String otp, long timestamp) {
        this.otp = otp;
        this.timestamp = timestamp;
    }

}
