package evg.testt.controller;

import evg.testt.dto.GroupDTO;
import evg.testt.model.Group;
import evg.testt.model.Student;
import evg.testt.model.Teacher;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.GroupService;
import evg.testt.service.StudentService;
import evg.testt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class GroupController {

//    @Autowired
//    private SpringOvalValidator validator;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;

    @Value("${pagination.page.size}")
    protected int pageSize;


    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String showGroups(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Boolean flagSorted,
                             Model model) throws SQLException {
        List<Teacher> teachers=teacherService.getAll();
        List<Student> students=studentService.getAll();
        if (flagSorted == null) flagSorted = false;

        int totalGroups = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        totalGroups = groupService.count();

        List<Group> groups = Collections.EMPTY_LIST;
        if (flagSorted == false) {
          groups = groupService.getByPage(currentPage);
        } else {
            groups = groupService.getByPageSorted(currentPage);
        }

        pages = ((totalGroups/ pageSize) + 1);

        if (totalGroups % pageSize == 0)
            pages--;
        groups = groupService.getAll();
        model.addAttribute("groups",groups);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        model.addAttribute("teachers",teachers);
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

    @RequestMapping(value = "/group/info")
    public String groupInfo(Model model, @RequestParam int group_id) throws SQLException {

        Group group = groupService.getById(group_id);

        model.addAttribute("group", group);

        return "persons/group-info";
    }
}
