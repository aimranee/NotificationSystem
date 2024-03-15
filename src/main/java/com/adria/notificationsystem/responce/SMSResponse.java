package com.adria.notificationsystem.responce;

import com.adria.notificationsystem.models.SMSInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@RequiredArgsConstructor
@Getter
public class SMSResponse {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String status;

    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("smsinfo")
    @Transient
    private ArrayList<SMSInfo> smsInfo;
}
