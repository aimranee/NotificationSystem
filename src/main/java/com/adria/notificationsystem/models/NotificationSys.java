package com.adria.notificationsystem.models;

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSys {

    private Event event;

    private Recipient recipient;

}
