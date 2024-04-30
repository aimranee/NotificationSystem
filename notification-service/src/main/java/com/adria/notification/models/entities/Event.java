package com.adria.notification.models.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {

    @Column(unique = true)
    private String name;
    private boolean editable;
    private String notificationType;

}
