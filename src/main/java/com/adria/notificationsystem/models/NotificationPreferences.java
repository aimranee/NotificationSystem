package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationPreferences extends AbstractEntity{

    @ManyToOne
    private Recipient recipient;
    @ManyToOne
    private Event event;

}
