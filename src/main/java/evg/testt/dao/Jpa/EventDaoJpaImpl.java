package evg.testt.dao.Jpa;

import evg.testt.dao.EventDao;
import evg.testt.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventDaoJpaImpl extends BaseDaoJpaImpl<Event>implements EventDao {

}
