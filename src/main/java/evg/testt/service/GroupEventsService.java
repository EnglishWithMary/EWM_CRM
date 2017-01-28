package evg.testt.service;

import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import evg.testt.model.GroupEvent;
import evg.testt.model.Room;

import java.sql.Date;
import java.util.List;

public interface GroupEventsService extends Service<GroupEvent> {

    List<GroupEvent> getAllByGroupId(Integer id);

    List<GroupEvent> getAllByDate(Date start, Date end);

    List<GroupEvent> getAllByRoom(Room room);

    List<GroupEvent> getAllByGroupIdAndRoomId(Integer groupId, Room room);

    List<GroupEvent> getAllByNotGroupIdAndRoomId(Integer groupId, Room room);
}

