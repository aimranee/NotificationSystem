package com.adria.notificationsystem.controller;

import com.adria.notificationsystem.dto.request.EmailRequestDto;
import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.dto.response.EmailResponseDto;
import com.adria.notificationsystem.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/push-notification")
    public ResponseEntity<EmailResponseDto> sendNotification(@Valid @RequestBody NotificationRequestDto requestDTO) {
        return notificationService.sendNotification(requestDTO);
    }

}
