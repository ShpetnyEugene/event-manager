package com.shpetny.services;

import com.shpetny.models.Event;
import com.shpetny.models.Group;
import com.shpetny.persistence.EventRepository;
import com.shpetny.persistence.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Service
public class EventService {

    private final EventRepository repository;
    private final GroupRepository groupRepository;

    @Autowired
    public EventService(EventRepository repository, GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
        this.repository = repository;
    }

    public void createEvent(Event event, String idGroup) {
        Group group = groupRepository.findById(idGroup);
        group.getEvents().add(event);
        groupRepository.save(group);
        repository.save(event);
    }


    public List<Event> getEventsNearly() {
//        return repository.
        return null;
    }

    public List<Event> getAllEvents(String idGroup) {
        return groupRepository.findById(idGroup).getEvents();
    }
}
