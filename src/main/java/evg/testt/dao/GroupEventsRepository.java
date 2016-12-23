package evg.testt.dao;

import evg.testt.model.GroupEvent;

import java.util.List;

public interface GroupEventsRepository extends BaseRepository<GroupEvent> {

    List<GroupEvent> findAllByGroupId(Integer id);

    List<GroupEvent> findAllByRoomId(Integer id);

}
