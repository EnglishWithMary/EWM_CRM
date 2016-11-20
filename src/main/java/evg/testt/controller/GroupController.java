package evg.testt.controller;

import evg.testt.dto.GroupDTO;
import evg.testt.model.Group;
import evg.testt.model.Teacher;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.GroupService;
import evg.testt.service.PersonService;
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
    public ModelAndView showGroups() {
        List<Group> groupList = Collections.EMPTY_LIST;
        try {
            groupList = groupService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.GROUP_ALL, "groups", groupList);
    }

    @RequestMapping(value = "/groupAdd")
    public ModelAndView addLead(Model model) {
        GroupDTO groupDTO = new GroupDTO();
        try {
            List<Teacher> teacherList = teacherService.getAll();
            groupDTO.setTeacherList(teacherList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("group", groupDTO);
        return new ModelAndView(JspPath.GROUP_ADD);
    }

    @RequestMapping(value = "/groupSave", method = RequestMethod.POST)
    public ModelAndView saveLead(@ModelAttribute("group") @Validated Group group,
                                 BindingResult bindingResult) {
        validator.validate(group, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView(JspPath.LEAD_ADD);
        }
        Group newGroup = new Group();
        newGroup.setName(group.getName());
        try {
            groupService.insert(newGroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showGroups();
    }


}
