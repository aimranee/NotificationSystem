package com.adria.notificationsystem.controllers;

import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notificationsystem.service.IPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("preferences")
public class PreferencesController {

    private final IPreferencesService preferencesService;

    @PostMapping("/save")
    public ResponseEntity<SavePreferencesResponseDto> save(@Valid @RequestBody SavePreferencesRequestDto preferencesDto){
        return ResponseEntity.ok().body(preferencesService.save(preferencesDto));
    }
}
