package evg.testt.dao.Jpa;

import evg.testt.dao.RoomRepository;
import evg.testt.model.Room;
import org.springframework.stereotype.Repository;

@Repository
public class RoomRepositoryJpaImpl extends BaseRepositoryJpaImpl<Room> implements RoomRepository{

}
