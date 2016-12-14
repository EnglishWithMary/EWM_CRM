package evg.testt.google.utils.calendar;

import com.google.api.services.calendar.model.Event;
import evg.testt.model.RoomEvent;

import java.util.ArrayList;
import java.util.List;

public class RoomsEventsHelper {
    public static List<RoomEvent> convertGoogleEventsToRoomEvents(List<Event> events){
        List<RoomEvent> list = new ArrayList<>();
        for (Event event : events){
            list.add(convertGoogleEventToRoomEvent(event));
        }
        return  null;
    }

    private static RoomEvent convertGoogleEventToRoomEvent(Event event){
        RoomEvent roomEvent = new RoomEvent();
        roomEvent.setTitle(event.getSummary());
        roomEvent.setStart(DateGoogleConverter.convertGoogleDateTimeToDate(event.getStart()));
        roomEvent.setEnd(DateGoogleConverter.convertGoogleDateTimeToDate(event.getEnd()));
        return roomEvent;
    }

    private static Event convertRoomEventToGoogleEvent(RoomEvent roomEvent){
        Event event = new Event();
        event.setSummary(roomEvent.getTitle());
        event.setStart(DateGoogleConverter.convertDateToGoogleTimeDate(roomEvent.getStart()));
        event.setEnd(DateGoogleConverter.convertDateToGoogleTimeDate(roomEvent.getEnd()));
        return event;
    }
}
