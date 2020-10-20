package qdo_ln.light_system_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdo_ln.light_system_testing.entities.Event;
import qdo_ln.light_system_testing.repositories.EventRepository;
import qdo_ln.light_system_testing.services.intefeces.EventService;

@Service
public class EventServiceImpl implements EventService {

   private EventRepository eventRepository;

   @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event save(Event event) {
        return null;
    }
}
