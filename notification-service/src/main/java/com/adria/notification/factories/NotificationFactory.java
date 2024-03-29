package com.adria.notification.factories;

import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.dto.response.NotificationResponseDto;
import com.adria.notification.services.INotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class NotificationFactory {

    private final Map<String, INotificationService> notificationServiceMap;

    public INotificationService getNotificationService(String notificationType) {
        INotificationService notificationService = notificationServiceMap.get(notificationType);
        if (notificationService == null) {
            throw new RuntimeException("Unsupported notification type");
        }

        return notificationService;
    }

    public ResponseEntity<NotificationResponseDto> pushNotification(List<MultipartFile> files, NotificationRequestDto requestDto) {
        INotificationService notificationService = getNotificationService(requestDto.getNotificationType());
        if (files == null || files.size() == 0) {
            return notificationService.sendNotification(requestDto);
        } else {
            return notificationService.sendNotificationWithFiles(files, requestDto);
        }
    }
}
