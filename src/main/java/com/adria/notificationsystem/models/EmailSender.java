package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class EmailSender extends AbstractEntity{


    private String smtpHost;
    private int smtpPort;

}
