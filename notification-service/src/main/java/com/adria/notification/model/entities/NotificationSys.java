package com.adria.notification.model.entities;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSys {

    private Event event;
    private Recipient recipient;
    private String notificationType;

}
