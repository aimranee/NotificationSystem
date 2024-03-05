package com.adria.notificationsystem.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@RequiredArgsConstructor
@Setter
public class SMSInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("sms_status")
    private String smsStatus;
    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("sms_type")
    private String smsType;

    @JsonProperty("sms_body")
    private String smsBody;

    @JsonProperty("csms_id")
    private String csmsId;

    @JsonProperty("reference_id")
    private String referenceId;
}
