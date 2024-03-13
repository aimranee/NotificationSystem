package com.adria.notificationsystem.factories;

import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationFactory {

    private final Map<String, NotificationService> notificationServiceMap;

    public NotificationService getNotificationService(String notificationType) {
        NotificationService notificationService = notificationServiceMap.get(notificationType);
        if (notificationService == null) {
            throw new RuntimeException("Unsupported notification type");
        }

        return notificationService;
    }

    public void pushNotification(NotificationRequestDto requestDto) {
        NotificationService notificationService = getNotificationService(requestDto.getEventType());
        notificationService.sendNotification(requestDto);
    }
}
