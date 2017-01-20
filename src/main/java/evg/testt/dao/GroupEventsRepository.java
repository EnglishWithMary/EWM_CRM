package evg.testt.dao;

import evg.testt.model.GroupEvent;
import evg.testt.model.Room;

import java.sql.Date;
import java.util.List;

public interface GroupEventsRepository extends BaseRepository<GroupEvent> {

    List<GroupEvent> findAllByGroupId(Integer id);

    List<GroupEvent> findAllByDate(Date start, Date end);

    List<GroupEvent> findAllByRoom(Room room);

}
