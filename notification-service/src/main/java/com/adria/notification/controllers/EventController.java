package com.adria.notification.controllers;

import com.adria.notification.dto.request.event.EventRequestDto;
import com.adria.notification.dto.request.event.UpdateEventDto;
import com.adria.notification.dto.response.EventResponseDto;
import com.adria.notification.services.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    private final IEventService eventService;

    @PostMapping("/save")
    public ResponseEntity<EventRequestDto> save(@Valid @RequestBody EventRequestDto eventDto){
        return ResponseEntity.ok().body(eventService.save(eventDto));
    }

    @PutMapping("/update")
    public ResponseEntity<EventResponseDto> update(@Valid @RequestBody UpdateEventDto eventDto){
        return ResponseEntity.ok().body(eventService.update(eventDto));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@Valid @PathVariable UUID id){
        eventService.delete(id);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EventResponseDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok().body(eventService.findById(id));
    }

    @GetMapping("/find/{notificationType}")
    public ResponseEntity<List<EventResponseDto>> findById(@PathVariable String notificationType){
        return ResponseEntity.ok().body(eventService.findByNotificationType(notificationType));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<EventResponseDto>> findAll(){
        return ResponseEntity.ok().body(eventService.findAll());
    }

}
