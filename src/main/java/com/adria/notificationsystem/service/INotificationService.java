package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface NotificationService <T>{

    ResponseEntity<T> sendNotification(NotificationRequestDto requestDTO);
//    ResponseEntity<T> sendNotificationWithFiles(MultipartFile file, NotificationRequestDto requestDTO);

}
