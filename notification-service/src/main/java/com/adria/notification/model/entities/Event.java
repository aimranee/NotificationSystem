package com.adria.notification.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {

    @Column(unique = true)
    private String type;
    private boolean editable;
    private String message;
    private String subject;

}
