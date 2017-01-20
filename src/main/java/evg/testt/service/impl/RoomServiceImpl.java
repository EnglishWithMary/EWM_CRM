package evg.testt.service.impl;

import com.google.api.services.calendar.model.Event;
import evg.testt.dao.RoomRepository;
import evg.testt.google.utils.calendar.GoogleCalendarAPI;
import evg.testt.model.Room;
import evg.testt.service.RoomService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Service
public class RoomServiceImpl extends BaseService<Room, RoomRepository> implements RoomService {

//    public void insertIntoCalendar(Room room) throws SQLException, IOException{
//        String calendarId = GoogleCalendarAPI.createCalendar(room.getName());
//        room.setCalendarId(calendarId);
//        insert(room);
//    }
//
//    public List<Event> getAllEventsInRoom(Integer id) throws SQLException, IOException{
//        return GoogleCalendarAPI.getEventsByCalendarId(
//                dao.findOne(id).getCalendarId()
//        );
//    }
//
//    public void insertEventIntoRoom(Event event, Integer id) throws SQLException, IOException{
//        GoogleCalendarAPI.insertEvent(dao.findOne(id).getCalendarId(), event);
//    }
//
    public Room getRoomByName(String name){
        return dao.findByName(name);
    }
}