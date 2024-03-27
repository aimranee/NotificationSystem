package com.adria.notification.models.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Preferences extends AbstractEntity {

    @ManyToOne
    private Recipient recipient;
    @ManyToOne
    private Event event;

}
