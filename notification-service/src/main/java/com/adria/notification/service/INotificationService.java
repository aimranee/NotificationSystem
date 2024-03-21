package com.adria.notification.service;

import com.adria.notification.dto.request.notification.NotificationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface INotificationService<T> {
    ResponseEntity<T> sendNotification(NotificationRequestDto requestDTO);
    ResponseEntity<T> sendNotificationWithFiles(List<MultipartFile> files, NotificationRequestDto requestDTO);
}
