package evg.testt.service;


import com.google.api.services.calendar.model.Event;
import evg.testt.model.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface RoomService extends Service<Room>{

    void insertIntoCalendar(Room room)throws SQLException, IOException;

    public List<Event> getAllEventsInRoom(Integer id) throws SQLException, IOException;

    public void insertEventIntoRoom(Event event, Integer id) throws SQLException, IOException;

}
