package com.adria.notificationsystem.models;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSys extends AbstractEntity{

    @ManyToOne
    private Event event;

    @ManyToOne
    private Recipient recipient;

    private String msgBody;
    private String subject;
    private String result;

}
