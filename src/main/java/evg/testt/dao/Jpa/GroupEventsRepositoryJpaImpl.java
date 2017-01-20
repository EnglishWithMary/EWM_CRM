package evg.testt.dao.Jpa;

import evg.testt.dao.GroupEventsRepository;
import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TemporalType;
import java.sql.Date;
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
    public List<GroupEvent> findAllByDate(Date start, Date end) {
        Query query = em.createQuery("SELECT g FROM group_events g WHERE g.startDate BETWEEN :startDate AND :endDate");
        query.setParameter("startDate", start);
        query.setParameter("endDate", end);
        return query.getResultList();
    }

    @Override
    public List<GroupEvent> findAllByRoom(Room room) {
        Query query = em.createQuery("SELECT g FROM group_events g WHERE g.room=:room");
        query.setParameter("room", room);
        return query.getResultList();
    }

    @Override
    public List<GroupEvent> findAllByRoomIdWhereGroupIsNotPresented(Integer groupId, Room room) {
        Query query = em.createQuery("SELECT g FROM group_events g WHERE g.room=:room AND g.groupId<>:groupId");
        query.setParameter("room", room);
        query.setParameter("groupId", groupId);
        return query.getResultList();
    }

    @Override
    public List<GroupEvent> findAllByGroupIdAndRoom(Integer groupId, Room room) {
        Query query = em.createQuery(
                "SELECT g FROM group_events g WHERE g.room=:room AND g.groupId=:groupId");
        query.setParameter("room", room);
        query.setParameter("groupId", groupId);
        return query.getResultList();
    }
}
