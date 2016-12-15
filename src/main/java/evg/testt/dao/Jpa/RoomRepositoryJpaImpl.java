package evg.testt.dao.Jpa;

import evg.testt.dao.RoomRepository;
import evg.testt.model.Room;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class RoomRepositoryJpaImpl extends BaseRepositoryJpaImpl<Room> implements RoomRepository{

    @Override
    public Room findByName(String name) {
        Query query = em.createQuery("SELECT room FROM rooms room WHERE room.name =: name");
        query.setParameter("name", name);
        return (Room)query.getSingleResult();
    }
}
