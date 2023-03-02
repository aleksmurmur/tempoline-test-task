package com.example.tempolinetesttask.event.api;

import com.example.tempolinetesttask.event.domain.Event;
import com.example.tempolinetesttask.event.domain.EventType;
import com.example.tempolinetesttask.event.dto.EventCreateOrUpdateRequest;
import com.example.tempolinetesttask.event.dto.EventResponse;
import com.example.tempolinetesttask.event.service.EventService;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EventResponse> create(@RequestBody @Valid EventCreateOrUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createEvent(request));
    }

    @GetMapping
    public ResponseEntity<Page<EventResponse>> getPage(@ParameterObject Pageable pageable, @RequestParam(required = false) EventType type) {
        return ResponseEntity.ok(service.getPage(pageable, type));
    }
}
