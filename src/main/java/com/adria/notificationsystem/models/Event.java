package com.adria.notificationsystem.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event extends AbstractEntity {

    @ManyToOne
    private EventType type;
    private boolean editable;

}
