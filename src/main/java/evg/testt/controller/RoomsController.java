package evg.testt.controller;

import com.google.api.services.calendar.model.Event;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.google.utils.calendar.RoomsEventsHelper;
import evg.testt.google.utils.calendar.TestCalendar;
import evg.testt.model.Person;
import evg.testt.model.RoomEvent;
import evg.testt.model.User;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;


@Controller
public class RoomsController {

    private TestCalendar testCalendar = new TestCalendar();

    @RequestMapping(value = {"/rooms", "/rooms/all"}, method = RequestMethod.GET)
    public String showAllRooms(Model model) throws IOException {
        List<Event> events = testCalendar.getCalendarEvents();
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