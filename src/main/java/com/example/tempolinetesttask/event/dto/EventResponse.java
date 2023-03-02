package com.example.tempolinetesttask.event.dto;

import com.example.tempolinetesttask.event.domain.EventType;

import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String description,
        LocalDateTime dateTime,
        EventType eventType
) {
}
