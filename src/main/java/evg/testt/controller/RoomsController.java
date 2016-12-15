package evg.testt.controller;

import com.google.api.services.calendar.model.Event;
import evg.testt.google.utils.calendar.GoogleCalendarAPI;
import evg.testt.model.RoomEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.List;


@Controller
public class RoomsController {

    private GoogleCalendarAPI googleCalendarAPI = new GoogleCalendarAPI();

    @RequestMapping(value = {"/rooms", "/rooms/all"}, method = RequestMethod.GET)
    public String showAllRooms(Model model) throws IOException {
//        List<Event> events = googleCalendarAPI.getCalendarEvents();
        List<RoomEvent> roomEvents = null;
//                RoomsEventsHelper.convertGoogleEventsToRoomEvents(events);
        model.addAttribute("room-events", roomEvents);
        return "rooms/all";
    }
    @RequestMapping(value = "/rooms/add", method = RequestMethod.GET)
    public String showAddRoom(Model model){
        return "rooms/add";
    }
}