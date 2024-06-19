package com.adria.notification.controllers;

import com.adria.notification.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notification.dto.response.PreferenceTokenDto;
import com.adria.notification.dto.response.preferences.PreferencesResponseDto;
import com.adria.notification.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notification.services.IPreferenceTokenService;
import com.adria.notification.services.IPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/preferences")
public class PreferencesController {

    private final IPreferencesService preferencesService;
    private final IPreferenceTokenService preferenceTokenService;

    @PostMapping("/saveAll")
    public ResponseEntity<List<SavePreferencesResponseDto>> saveAll(@Valid @RequestBody SavePreferencesRequestDto preferencesDto){
        return ResponseEntity.ok().body(preferencesService.saveAll(preferencesDto));
    }

    @GetMapping("/find/All")
    public ResponseEntity<List<PreferencesResponseDto>> findAll(){
        return ResponseEntity.ok().body(preferencesService.findAll());
    }

    @GetMapping("/find/byRecipientEmail")
    public ResponseEntity<List<PreferencesResponseDto>> findByRecipientEmail(@RequestParam String recipientEmail){
        return ResponseEntity.ok().body(preferencesService.findByRecipientEmail(recipientEmail));
    }

    @GetMapping("/find/byToken")
    public ResponseEntity<PreferenceTokenDto> findByToken(@RequestParam String token){
        return ResponseEntity.ok().body(preferenceTokenService.findByToken(token));
    }

}
