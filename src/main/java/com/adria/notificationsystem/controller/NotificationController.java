package com.adria.notificationsystem.controller;

import com.adria.notificationsystem.dto.request.NotificationRequestDto;
import com.adria.notificationsystem.dto.response.NotificationResponseDto;
import com.adria.notificationsystem.factories.NotificationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationFactory notificationFactory;

    @PostMapping("/push-notification")
    public ResponseEntity<NotificationResponseDto> sendNotification(@RequestPart(name = "files", required = false) List<MultipartFile> files,
                                                                    @Valid @RequestPart("notification") NotificationRequestDto requestDTO) {
        return notificationFactory.pushNotification(files, requestDTO);
    }

}
