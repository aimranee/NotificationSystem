package com.adria.notificationsystem.models;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSys {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Event event;

    @NotNull
    @ManyToOne
    private Recipient recipient;

    private String msgBody;
    private String subject;

}
