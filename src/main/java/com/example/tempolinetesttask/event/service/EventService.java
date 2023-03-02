package com.example.tempolinetesttask.event.service;

import com.example.tempolinetesttask.event.domain.Event;
import com.example.tempolinetesttask.event.dto.EventCreateOrUpdateRequest;
import com.example.tempolinetesttask.event.dto.EventResponse;
import com.example.tempolinetesttask.event.repository.EventRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<EventResponse> getPage(Pageable pageable) {
        Page<Event> eventsPage = repository.findAll(pageable);
        return eventsPage.map(this::convertToDto);
    }

    @Transactional
    public EventResponse createEvent(EventCreateOrUpdateRequest request) {
        Event persisted = repository.save(convertToEntity(request));
        return convertToDto(persisted);
    }

    private EventResponse convertToDto(Event event) {
        return new EventResponse(
                event.getId(),
                event.getDescription(),
                event.getDateTime(),
                event.getEventType()
        );
    }

    private Event convertToEntity(EventCreateOrUpdateRequest request) {
        return new Event(
                request.description(),
                request.dateTime(),
                request.eventType()
        );
    }
}
