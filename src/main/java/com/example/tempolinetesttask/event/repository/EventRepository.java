package com.example.tempolinetesttask.event.repository;

import com.example.tempolinetesttask.event.domain.Event;
import com.example.tempolinetesttask.event.domain.EventType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Page<Event> findAllByOrderByDateTimeDesc(Pageable pageable);
    Page<Event> findEventsByEventTypeEqualsOrderByDateTimeDesc(Pageable pageable, EventType type);
}
