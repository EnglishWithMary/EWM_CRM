package evg.testt.repository;

import evg.testt.model.Event;

import java.util.Collection;

public interface EventRepository {

    Collection<Event> getAll();

    Event findById(Integer id);

    void save(Event event);
}
