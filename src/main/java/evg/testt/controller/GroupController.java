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
    public ModelAndView showGroups() {
        List<Group> groups = Collections.EMPTY_LIST;
        List<Teacher> teachers=Collections.EMPTY_LIST;
        try {
            teachers=teacherService.getAll();
            groups = groupService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.GROUP_ALL, "groups", groups);
        modelAndView.addObject("teachers",teachers);
        modelAndView.addObject("groupFilter", new GroupDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/groupAdd")
    public ModelAndView addGroup(Model model) {
        ModelAndView modelAndView=new ModelAndView(JspPath.GROUP_ADD);
        GroupDTO groupDTO =  new GroupDTO();
        try {
            List<Teacher> teachers=teacherService.getAll();
            modelAndView.addObject("teachers",teachers);
            groupDTO.setName("Default Group");
        }catch (SQLException e){
            e.printStackTrace();
        }
        model.addAttribute("group", groupDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/groupSave")
    public ModelAndView saveGroup(@ModelAttribute("group") @Validated GroupDTO groupDTO,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ModelAndView(JspPath.GROUP_ADD);
        }
        Group newGroup =  new Group();
        newGroup.setName(groupDTO.getName());
        try {
            newGroup.setTeacher(teacherService.getById(groupDTO.getTeacherId()));
            groupService.insert(newGroup);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return showGroups();
    }

    @RequestMapping(value = "/groupFilter", method = RequestMethod.POST)
    public ModelAndView filterGroups(@RequestParam(required = false) Integer teacherId) {

        GroupDTO groupFilter= new GroupDTO();
        List<Group> groups = Collections.EMPTY_LIST;
        List<Teacher> teachers=Collections.EMPTY_LIST;
        try {
            teachers=teacherService.getAll();
            if(teacherId!=null){
                groupFilter.setTeacherId(teacherId);
                Teacher teacher =teacherService.getById(teacherId);
                groups = groupService.getByTeacher(teacher);
            }else{
                groups=groupService.getAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.GROUP_ALL, "groups", groups);
        modelAndView.addObject("teachers",teachers);
        modelAndView.addObject("groupFilter", groupFilter);
        return modelAndView;
    }
}
