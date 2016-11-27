package evg.testt.dao.Jpa;

import evg.testt.model.Event;
import evg.testt.dao.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryJpaImpl extends BaseRepositoryJpaImpl<Event>implements EventRepository {

}
