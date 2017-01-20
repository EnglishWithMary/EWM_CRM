package evg.testt.controller;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.gson.Gson;
import evg.testt.google.utils.calendar.DateGoogleConverter;
import evg.testt.google.utils.calendar.RoomsEventsHelper;
import evg.testt.model.FullcalendarEvent;
import evg.testt.model.Room;
import evg.testt.model.RoomEvent;
import evg.testt.service.GroupEventsService;
import evg.testt.service.GroupService;
import evg.testt.service.RoomService;
import evg.testt.util.fullcalendar.FullcalendarHeleper;
import evg.testt.util.helpers.RoomUpdateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class RoomsController {

    @Autowired
    RoomService roomService;
    @Autowired
    GroupEventsService groupEventsService;

    @ModelAttribute
    private Room createRoom() {
        return new Room();
    }

    @RequestMapping(value = {"/rooms", "/rooms/all"}, method = RequestMethod.GET)
    public String showAllRooms(Model model) throws SQLException, IOException {
        List<Room> rooms = roomService.getAll();
        model.addAttribute("rooms", rooms);
        return "rooms/all";
    }

    @RequestMapping(value = "/rooms/{ID}/info", method = RequestMethod.GET)
    public String getRoomInfo(Model model, @PathVariable(value = "ID") Integer roomId)
            throws SQLException, IOException {
        Room room = roomService.getById(roomId);
        if (room == null) {
            return "redirect:/rooms/all";
        }
        model.addAttribute("room", room);
        return "rooms/info";
    }

    @RequestMapping(value = "/rooms/add", method = RequestMethod.GET)
    public String showAddRoom(Model model) {
        model.addAttribute("room", createRoom());
        return "rooms/add";
    }

    @RequestMapping(value = "/rooms/add", method = RequestMethod.POST)
    public String saveRoom(Model model,
                           @ModelAttribute("room") @Validated Room room, BindingResult result)
            throws SQLException, IOException {
        if (result.hasErrors()) {
            return "rooms/add";
        }
        roomService.insert(room);
        return "redirect:/rooms";
    }

    @RequestMapping(value = "/rooms/{ID}/edit", method = RequestMethod.GET)
    public String showEditRoom(Model model, @PathVariable(value = "ID")Integer id) throws SQLException{
        Room room = roomService.getById(id);
        if(room == null){
            return "redirect: rooms/all";
        }
        model.addAttribute("room", room);
        return "rooms/edit";
    }

    @RequestMapping(value = "/rooms/{ID}/edit", method = RequestMethod.POST)
    public String saveEditRoom(Model model, @PathVariable(value = "ID")Integer id,
                           @ModelAttribute("room") @Validated Room room, BindingResult result)
            throws SQLException, IOException {
        if (result.hasErrors()) {
            return "rooms/edit";
        }
        if(roomService.getById(room.getId()) != null) {
            roomService.update(room);
        }
        return "redirect:/rooms/" + id.toString() + "/info";
    }

    @ResponseBody
    @RequestMapping(value = "/rooms/{ID}/info/events", method = RequestMethod.GET)
    public String getEventsByRoomId(@PathVariable(value = "ID") Integer id)
            throws SQLException, IOException {
        List<FullcalendarEvent> events = FullcalendarHeleper
                .convertGroupEventsToFullcalendarEventsWithUrls(
                        groupEventsService.getAllByRoom(
                                roomService.getById(id)
                        )
                );
        return new Gson().toJson(events);
    }

    @RequestMapping(value = "/rooms/{ID}/add-event", method = RequestMethod.GET)
    public String showAddEvent(Model model, @PathVariable(value = "ID") Integer id) {
        model.addAttribute("RoomEvent", new RoomEvent())
                .addAttribute("room_id", id);
        return "rooms/add/event";
    }

    @RequestMapping(value = "/rooms/{ID}/add-event", method = RequestMethod.POST)
    public String saveEvent(Model model, @ModelAttribute("RoomEvent") @Validated RoomEvent roomEvent,
                            BindingResult result, @PathVariable(value = "ID") Integer id)
            throws SQLException, IOException {
        if (result.hasErrors()) {
            model.addAttribute("room_id", id);
            return "rooms/add/event";
        }
        Event event = RoomsEventsHelper.convertRoomEventToGoogleEvent(roomEvent);
//        roomService.insertEventIntoRoom(event, id);
        return "redirect:/rooms/" + id.toString() + "/info";
    }
}