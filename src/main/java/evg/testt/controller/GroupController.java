package evg.testt.controller;

import evg.testt.dto.GroupDTO;
import evg.testt.model.Group;
import evg.testt.model.Teacher;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.GroupService;
import evg.testt.service.TeacherService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class GroupController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    GroupService groupService;

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public String showGroups(Model model) throws SQLException {
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();
        model.addAttribute("groups", groups)
                .addAttribute("teachers", teachers)
                .addAttribute("groupFilter", new GroupDTO());
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
    public String saveGroup(Model model, @ModelAttribute("group") @Validated GroupDTO groupDTO,
                            BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "groups/add";
        }
        Group newGroup = new Group();
        newGroup.setName(groupDTO.getName());
        newGroup.setTeacher(teacherService.getById(groupDTO.getTeacherId()));
        groupService.insert(newGroup);
        return "groups/all";
    }

    @RequestMapping(value = "/groupFilter", method = RequestMethod.POST)
    public String filterGroups(Model model, @RequestParam(required = false) Integer teacherId)
            throws SQLException {

        GroupDTO groupFilter = new GroupDTO();
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = Collections.EMPTY_LIST;
        if (teacherId != null) {
            groupFilter.setTeacherId(teacherId);
            Teacher teacher = teacherService.getById(teacherId);
            groups = groupService.getByTeacher(teacher);
        } else {
            groups = groupService.getAll();
        }
        model.addAttribute("teachers", teachers)
                .addAttribute("groupFilter", groupFilter);
        return "groups/all";
    }
}
