package evg.testt.service.impl;

import evg.testt.dao.GroupEventsRepository;
import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import evg.testt.service.GroupEventsService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class GroupEventsServiceImpl extends BaseService<GroupEvent, GroupEventsRepository>
        implements GroupEventsService {

    @Override
    public List<GroupEvent> getAllByGroupId(Integer id) {
        return dao.findAllByGroupId(id);
    }

    @Override
    public List<GroupEvent> getAllByDate(Date start, Date end) {
        return dao.findAllByDate(start, end);
    }

    @Override
    public List<GroupEvent> getAllByRoom(Room room) {
        return dao.findAllByRoom(room);
    }

    @Override
    public List<GroupEvent> getAllByGroupIdAndRoomId(Integer groupId, Room room) {
        return dao.findAllByGroupIdAndRoom(groupId, room);
    }

    @Override
    public List<GroupEvent> getAllByNotGroupIdAndRoomId(Integer groupId, Room room) {
        return dao.findAllByRoomIdWhereGroupIsNotPresented(groupId, room);
    }

    @Override
    public void update(GroupEvent groupEvent) {
        GroupEvent updatedGroupEvent = dao.findOne(groupEvent.getId());
        updatedGroupEvent.setTitle(groupEvent.getTitle());
        updatedGroupEvent.setStartDate(groupEvent.getStartDate());
        updatedGroupEvent.setEndDate(groupEvent.getEndDate());
        dao.save(updatedGroupEvent);
    }

}



