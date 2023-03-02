package com.example.tempolinetesttask.event.dto;

import com.example.tempolinetesttask.event.domain.EventType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record EventCreateOrUpdateRequest(
        @NotEmpty
        String description,
        @NotNull
        LocalDateTime dateTime,
        @NotNull
        EventType eventType
) {
}
