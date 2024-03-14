package com.adria.notificationsystem.model;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSys {

    private Event event;
    private Recipient recipient;
    private String notificationType;

}
