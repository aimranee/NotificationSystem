package com.adria.notificationsystem.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {

    @Column(unique = true)
    private String eventType;
    private boolean editable;
    private String message;
    private String subject;

}
