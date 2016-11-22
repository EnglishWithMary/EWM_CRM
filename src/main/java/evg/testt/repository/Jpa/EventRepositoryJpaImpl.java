package evg.testt.repository.Jpa;

import evg.testt.model.Event;
import evg.testt.repository.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryJpaImpl extends BaseRepositoryJpaImpl<Event>implements EventRepository {

}
