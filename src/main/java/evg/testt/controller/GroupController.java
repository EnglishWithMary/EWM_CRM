package evg.testt.controller;

import com.google.gson.Gson;
import evg.testt.dto.GroupDTO;
import evg.testt.model.*;
import evg.testt.service.*;
import evg.testt.util.fullcalendar.FullcalendarHeleper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class GroupController {

    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private GroupEventsService groupEventsService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String showGroups(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Boolean flagSorted,
                             Model model) throws SQLException {
        List<Teacher> teachers = teacherService.getAll();
        List<Student> students = studentService.getAll();
        if (flagSorted == null) flagSorted = false;
        int totalGroups = 0, pages = 0, currentPage = 1;
        if (page != null) {
            if (page > 0) {
                currentPage = page;
            }
        }
        totalGroups = groupService.count();
        List<Group> groups = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            groups = groupService.getByPage(currentPage);
        } else {
            groups = groupService.getByPageSorted(currentPage);
        }
        pages = ((totalGroups / pageSize) + 1);
        if (totalGroups % pageSize == 0)
            pages--;
        groups = groupService.getAll();
        model.addAttribute("groups", groups);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        model.addAttribute("teachers", teachers);
        model.addAttribute("students", students);
        model.addAttribute("groupFilter", new GroupDTO());
        model.addAttribute("groupFilterStudentsByGroup", new GroupDTO());
        return "groups/all";
    }

    @RequestMapping(value = "/groupAdd")
    public String addGroup(Model model) throws SQLException {
        List<Teacher> teachers = teacherService.getAll();
        model.addAttribute("teachers", teachers);
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Default Group");
        model.addAttribute("group", groupDTO);
        return "groups/add";
    }

    @RequestMapping(value = "/groupSave")
    public String saveGroup(@ModelAttribute("group") @Valid GroupDTO groupDTO,
                            BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "groups/add";
        }
        Group newGroup = new Group();
        newGroup.setName(groupDTO.getName());
        newGroup.setLanguage(groupDTO.getLanguage());
        groupService.insert(newGroup);
        if (groupDTO.getTeacherId() != null) {
            newGroup.setTeacher(teacherService.getById(groupDTO.getTeacherId()));
            groupService.update(newGroup);
        }
        return "redirect:/groups";
    }

    @RequestMapping(value = "/groupDelete")
    public String groupDelete(@RequestParam Integer id) throws SQLException {
        Group group = groupService.getById(id);
        groupService.delete(group);
        return "groups/all";
    }

    @RequestMapping(value = "/groupFilter", method = RequestMethod.POST)
    public String filterGroups(Model model, @RequestParam(required = false) Integer teacherId)
            throws SQLException {
        GroupDTO groupFilter = new GroupDTO();
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups;
        if (teacherId != null) {
            groupFilter.setTeacherId(teacherId);
            Teacher teacher = teacherService.getById(teacherId);
            groups = groupService.getByTeacher(teacher);
        } else {
            groups = groupService.getAll();
        }
        model.addAttribute("groups", groups)
                .addAttribute("teachers", teachers)
                .addAttribute("groupFilter", groupFilter);
        return "groups/all";
    }

    @RequestMapping(value = "/group/{ID}/info")
    public String groupInfo(Model model, @PathVariable(value = "ID") Integer groupId)
            throws SQLException {
        if (!groupService.isExists(groupId)) {
            return "redirect:/groups";
        }
        Group group = groupService.getById(groupId);
        model.addAttribute("group", group);
        return "persons/group-info";
    }

    @RequestMapping(value = "/group/{ID}/calendar")
    public String showGroupCalendar(Model model, @PathVariable(value = "ID") Integer groupId)
            throws SQLException {
        if (!groupService.isExists(groupId)) {
            return "redirect:/groups";
        }
        model.addAttribute("rooms", roomService.getAll());
        model.addAttribute("group", groupService.getById(groupId));
        return "group/calendar";
    }

    @ResponseBody
    @RequestMapping(value = "/group/{ID}/calendar/events", method = RequestMethod.GET)
    public String getEventsByRoomId(@PathVariable(value = "ID") Integer id)
            throws SQLException {
        List<FullcalendarEvent> groupEvents = FullcalendarHeleper
                .convertGroupEventsToFullcalendarEvents(groupEventsService.getAllByGroupId(id));
        return new Gson().toJson(groupEvents);
    }

    @RequestMapping(value = "/group/{ID}/room/choose-room", method = RequestMethod.GET)
    public String chooseRomeForEvent(Model model, @PathVariable(value = "ID") Integer id)
            throws SQLException {
        model.addAttribute("rooms", roomService.getAll())
                .addAttribute("group_id", id);
        return "group/choose-room";
    }


    @RequestMapping(value = "/group/{ID}/add-event", method = RequestMethod.GET)
    public String showAddEvent(Model model, @PathVariable(value = "ID") Integer id)
            throws SQLException {
        model.addAttribute("GroupEvent", new GroupEvent())
                .addAttribute("group_id", id)
                .addAttribute("rooms", roomService.getAll());
        return "group/add/event";
    }

    @RequestMapping(value = "/group/{ID}/add-event", method = RequestMethod.POST)
    public String saveEvent(Model model, @ModelAttribute("RoomEvent") @Valid GroupEvent groupEvent,
                            BindingResult result, @PathVariable(value = "ID") Integer id)
            throws SQLException {
        if (result.hasErrors()) {
            model.addAttribute("group_id", id)
                    .addAttribute("rooms", roomService.getAll());
            return "group/add/event";
        }
        groupEventsService.insert(groupEvent);
        return "redirect:/group/" + id.toString() + "/calendar";
    }

    @ResponseBody
    @RequestMapping(value = "/group/{group_id}/calendar/room/{room_id}/add-event-test",
            method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveEventAjaxMethod(@RequestBody FullcalendarEvent fullcalendarEvent,
                                      @PathVariable(value = "group_id") Integer groupId,
                                      @PathVariable(value = "room_id") Integer roomId,
                                      HttpServletResponse response
    ) throws SQLException {
        Room room = roomService.getById(roomId);
        GroupEvent groupEvent = FullcalendarHeleper
                .convertFullcalendarEventToGroupEvent(fullcalendarEvent);
        groupEvent.setRoom(room);
        groupEvent.setGroupId(groupId);
        if (groupEvent.getTitle().equals("")) {
            groupEvent.setTitle("Default Title");
        }
        groupEventsService.insert(groupEvent);
        return new Gson().toJson("msg = success, code = 200");
    }

    @ResponseBody
    @RequestMapping(value = "/group/{group_id}/calendar/delete/event", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deleteEventAjaxMethod(@RequestBody FullcalendarEvent fullcalendarEvent)
            throws SQLException {
        GroupEvent groupEvent = groupEventsService.getById(fullcalendarEvent.getId());
        groupEventsService.delete(groupEvent);
        return new Gson().toJson("msg = success, code = 200");
    }

    @ResponseBody
    @RequestMapping(value = "/groups/this-day-events", method = RequestMethod.GET)
    public String getEventsAllDay(@RequestParam(value = "start") Date start,
                                  @RequestParam(value = "end") Date end) throws SQLException {
        List<FullcalendarEvent> groupEvents = FullcalendarHeleper
                .convertGroupEventsToFullcalendarEventsWithUrls(
                        groupEventsService.getAllByDate(start, end));
        return new Gson().toJson(groupEvents);
    }
}
