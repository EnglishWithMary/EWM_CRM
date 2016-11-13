package evg.testt.repository.Jpa;

import evg.testt.model.Event;
import evg.testt.repository.EventRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class EventRepositoryJpaImpl implements EventRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Event> getAll() {
        Query query = em.createQuery("SELECT event FROM events event");
        return query.getResultList();
    }

    @Override
    public Event findById(Integer id) {
        Query query = em.createQuery("SELECT event FROM events event WHERE event.id =:id");
        query.setParameter("id", id);
        return (Event) query.getSingleResult();
    }

    @Override
    public void save(Event event) {
        if(event.getId() == null){
            em.persist(event);
        } else {
            em.merge(event);
        }
    }
}
