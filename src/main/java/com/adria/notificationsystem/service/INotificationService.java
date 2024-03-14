package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface INotificationService<T> {
    ResponseEntity<T> sendNotification(NotificationRequestDto requestDTO);
    ResponseEntity<T> sendNotificationWithFiles(List<MultipartFile> files, NotificationRequestDto requestDTO);
}
