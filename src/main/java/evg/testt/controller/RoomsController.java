package evg.testt.controller;

import com.google.api.services.calendar.model.Event;
import evg.testt.model.Room;
import evg.testt.model.RoomEvent;
import evg.testt.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@Controller
public class RoomsController {

    @Autowired
    RoomService roomService;

    @ModelAttribute
    private Room createRoom() {
        return new Room();
    }

    @RequestMapping(value = {"/rooms", "/rooms/all"}, method = RequestMethod.GET)
    public String showAllRooms(Model model) throws SQLException, IOException {
        List<Room> rooms = roomService.getAll();
        for(Room room : rooms){
            room.setEvents(roomService.getAllEventsInRoom(room.getId()));
        }
        model.addAttribute("rooms", rooms);
        return "rooms/all";
    }

    @RequestMapping(value = "/rooms/add", method = RequestMethod.GET)
    public String showAddRoom(Model model) {
        model.addAttribute("room", createRoom());
        return "rooms/add";
    }

    @RequestMapping(value = "rooms/add", method = RequestMethod.POST)
    public String saveRoom(Model model, @ModelAttribute("room") @Validated Room room, BindingResult result)
            throws SQLException, IOException {
        if (result.hasErrors()) {
            return "rooms/add";
        }
        roomService.insertIntoCalendar(room);
        return "redirect:/rooms";
    }
}