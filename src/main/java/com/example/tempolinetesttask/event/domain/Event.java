package com.example.tempolinetesttask.event.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime dateTime;
    @Enumerated(value = EnumType.STRING)
    private EventType eventType;

    public Event(String description, LocalDateTime dateTime, EventType eventType) {
        this.description = description;
        this.dateTime = dateTime;
        this.eventType = eventType;
    }
}
