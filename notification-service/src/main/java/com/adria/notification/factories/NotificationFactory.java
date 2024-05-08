package com.adria.notification.factories;

import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.notification.NotificationRequestDto;
import com.adria.notification.dto.response.NotificationResponseDto;
import com.adria.notification.dto.response.event.EventResponseDto;
import com.adria.notification.services.IEventService;
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
    private final IEventService eventService;

    public INotificationService getNotificationService(String notificationType) {
        INotificationService notificationService = notificationServiceMap.get(notificationType);
        if (notificationService == null) {
            throw new RuntimeException("Unsupported notification type");
        }

        return notificationService;
    }

    public ResponseEntity<NotificationResponseDto> pushNotification(List<MultipartFile> files, NotificationRequestDto requestDto) {
        INotificationService notificationService;
        for (EventRequestDto eventRequestDto : requestDto.getEvent()){
            EventResponseDto eventDto = eventService.findByEventNameOnly(eventRequestDto.getEventName());
            notificationService = getNotificationService(eventDto.getNotificationType());
            if (files == null || files.isEmpty()) {
                return notificationService.sendNotification(requestDto);
            } else {
                return notificationService.sendNotificationWithFiles(files, requestDto);
            }
        }
        return null;
    }
}
