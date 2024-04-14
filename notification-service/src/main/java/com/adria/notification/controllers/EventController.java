package com.adria.notification.controllers;

import com.adria.notification.dto.request.EventRequestDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final IEventService eventService;

    @PostMapping("/save")
    public ResponseEntity<EventRequestDto> save(@Valid @RequestBody EventRequestDto eventDto){
        return ResponseEntity.ok().body(eventService.save(eventDto));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EventResponseDto>> findAll(){
        return ResponseEntity.ok().body(eventService.findAll());
    }

}
