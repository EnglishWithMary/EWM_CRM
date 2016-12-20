package evg.testt.dao.Jpa;

import evg.testt.dao.GroupEventsRepository;
import evg.testt.model.GroupEvent;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class GroupEventsRepositoryJpaImpl
        extends BaseRepositoryJpaImpl<GroupEvent>
        implements GroupEventsRepository {

    @Override
    public List<GroupEvent> findAllByGroupId(Integer id) {
        Query query = em.createQuery("SELECT g FROM group_events g WHERE g.groupId =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<GroupEvent> findAllByRoomId(Integer id) {
        Query query = em.createQuery("SELECT g FROM group_events g WHERE g.roomId =: id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
