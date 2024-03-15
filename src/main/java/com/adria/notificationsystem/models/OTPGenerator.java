package com.adria.notificationsystem.models;


import lombok.*;

@Getter
public class OTPGenerator {

    private String otp;

    private long timestamp;

    public OTPGenerator(String otp, long timestamp) {
        this.otp = otp;
        this.timestamp = timestamp;
    }

}
