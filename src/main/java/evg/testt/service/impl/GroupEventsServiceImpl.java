package evg.testt.service.impl;

import evg.testt.dao.GroupEventsRepository;
import evg.testt.model.FullcalendarEvent;
import evg.testt.model.GroupEvent;
import evg.testt.model.Room;
import evg.testt.service.GroupEventsService;
import evg.testt.util.fullcalendar.FullcalendarHeleper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
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
    public List<FullcalendarEvent> getAllByGroupIdAndRoomId(Integer groupId, Room room) {
        List<FullcalendarEvent> events = FullcalendarHeleper
                .convertGroupEventsToFullcalendarEventsDefinedAsBadTime(
                        dao.findAllByRoomIdWhereGroupIsNotPresented(groupId, room)
                );
        events.addAll(FullcalendarHeleper.convertGroupEventsToFullcalendarEvents(
                dao.findAllByGroupIdAndRoom(groupId, room)));
        return events;
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



