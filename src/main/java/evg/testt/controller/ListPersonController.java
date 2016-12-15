package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Person;
import evg.testt.model.Teacher;
import evg.testt.model.User;
import evg.testt.model.UserRole;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class ListPersonController {

    @Autowired
    PersonService personService;
    @Autowired
    UserService userService;

    @Autowired
    EWMcrmSecurityService ewMcrmSecurityService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = {"","/", "/home"}, method = RequestMethod.GET)
    public String showPersonOnHomePage(Model model) {
        List<User> users;
        List<Person> persons ;
        PersonDTO person = new PersonDTO();
        try {
            persons = personService.getAll();
        } catch (SQLException e) {
            persons = Collections.emptyList();
            users = Collections.emptyList();
            e.printStackTrace();
        }
        model.addAttribute("persons", persons);
        return "home";
    }
}
