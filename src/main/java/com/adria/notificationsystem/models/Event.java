package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {

    private String eventType;
    private boolean editable;
    private String message;
    private String subject;

}
