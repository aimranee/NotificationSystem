package com.adria.notificationsystem.service;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import org.springframework.http.ResponseEntity;

public interface NotificationService <T>{

    ResponseEntity<T> sendNotification(NotificationRequestDto requestDTO);
}
