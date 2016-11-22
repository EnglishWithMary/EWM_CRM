package evg.testt.controller.dashboard;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.util.JspPath;
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

import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    SpringOvalValidator validator;
    @Autowired
    ManagerService managerService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/personProfile", method = RequestMethod.GET)
    public ModelAndView profilePerson(@ModelAttribute("person") @Validated PersonDTO personDTO, BindingResult bindingResult, Principal principal) {
        validator.validate(personDTO, bindingResult);
        // проверка логина на уникальность
        Person person = new Person();
        try {
            person = personService.getPersonByUserLogin(principal.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.PROFILE,"person", person);
    }

    @RequestMapping(value = "/personUpdate", method = RequestMethod.POST)
    public ModelAndView updatePerson(@ModelAttribute("person") @Validated PersonDTO personDTO, BindingResult bindingResult) {
        validator.validate(personDTO, bindingResult);
        // проверка логина на уникальность
        try {
            Person updatePerson = personService.getById(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.MANAGER_ADD);
    }
}


