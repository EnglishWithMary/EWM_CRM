package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    SpringOvalValidator validator;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String showTeachers(Model model) throws SQLException{
        List<Person> persons = new ArrayList<Person>();

        List<Teacher> teachers = teacherService.getAll();
        for (Teacher teacher : teachers){
                persons.add(teacher.getPerson());
            }
        model.addAttribute("teachers", persons);
        return "teachers/all";
    }

    @RequestMapping(value = "/teacherAdd")
    public String addTeacher(Model model) {
        PersonDTO person =  new PersonDTO();
        model.addAttribute("teacher", person);
        return "teachers/add";
    }

    @RequestMapping(value = "/teacherSave", method = RequestMethod.POST)
    public String saveTeacher(@ModelAttribute("teacher") @Validated PersonDTO personDTO, BindingResult bindingResult,
                              Model model) throws SQLException {
        validator.validate(personDTO, bindingResult);
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                UserRole roleId = UserRole.ROLE_TEACHER;

                Role role = roleService.getById(roleId.getRoleId());

                Person newPerson = new Person();
                User newUser = new User();
                Teacher newTeacher = new Teacher();

                newPerson.setFirstName(personDTO.getFirstName());
                newPerson.setLastName(personDTO.getLastName());
                newPerson.setMiddleName(personDTO.getMiddleName());

                newUser.setRole(role);
                newUser.setPassword(passwordEncoder.encode(personDTO.getPassword()));
                newUser.setLogin(personDTO.getLogin());

                newTeacher.setPerson(newPerson);
                newTeacher.setUser(newUser);

                teacherService.insert(newTeacher);

            return "redirect:/teachers";
        } else {
            return "teachers/add";
        }
    }

    @RequestMapping(value = "/teacherSortByDate", method = RequestMethod.POST)
    public String filterTeachers(Model model) throws SQLException {
        List<Person> persons=new ArrayList<>();
        List<Teacher> teachers = teacherService.getSortedByRegistrationDate();
        for (Teacher teacher: teachers){
                persons.add(teacher.getPerson());
            }
            model.addAttribute("teachers", persons);
        return "teachers/all";
    }

}
/*
        List<Teacher> teachers = Collections.EMPTY_LIST;
        List<Person> persons = new ArrayList<Person>();
        try {
            teachers = teacherService.getAll();
            for (Teacher item : teachers){
                persons.add(item.getPerson());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.TEACHER_ALL, "teachers", persons);
*/