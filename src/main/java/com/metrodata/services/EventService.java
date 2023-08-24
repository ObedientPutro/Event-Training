package com.metrodata.services;

import com.metrodata.entities.Event;
import com.metrodata.entities.models.ResponseData;
import com.metrodata.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private EventRepository eventRepository;


    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById (Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with ID: " + id + " not found"));
    }

    public ResponseData<Event> insertEvent(Event event) {
        try {
            return new ResponseData<>(eventRepository.save(event), "Event successfully created");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    public Event updateEvent(long id, Event eventData) {
        Event event = getEventById(id);
        event.setName(eventData.getName());
        event.setTheme(eventData.getTheme());
        event.setSlug(eventData.getSlug());
        event.setStartDateTime(eventData.getStartDateTime());
        event.setEndDateTime(eventData.getEndDateTime());
        event.setStartRegistration(eventData.getEndRegistration());
        event.setCapacity(eventData.getCapacity());
        event.setOverview(eventData.getOverview());
        event.setDescription(eventData.getDescription());
        event.setVenue(eventData.getVenue());
        event.setLocation(eventData.getLocation());
        return eventRepository.save(event);
    }

    public Event deleteEvent(Long id) {
        Event event = getEventById(id);
        eventRepository.delete(event);
        return event;
    }


}
