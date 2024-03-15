package com.adria.notificationsystem.controllers;

import com.adria.notificationsystem.dto.request.preferences.SavePreferencesRequestDto;
import com.adria.notificationsystem.dto.response.preferences.GetPreferencesResponseDto;
import com.adria.notificationsystem.dto.response.preferences.SavePreferencesResponseDto;
import com.adria.notificationsystem.service.IPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("preferences")
public class PreferencesController {

    private final IPreferencesService preferencesService;

    @PostMapping("/save")
    public ResponseEntity<List<SavePreferencesResponseDto>> save(@Valid @RequestBody List<SavePreferencesRequestDto> preferencesDto){
        return ResponseEntity.ok().body(preferencesService.save(preferencesDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<GetPreferencesResponseDto>> findAll(){
        return ResponseEntity.ok().body(preferencesService.findAll());
    }

}
