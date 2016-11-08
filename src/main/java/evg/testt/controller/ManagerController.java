package evg.testt.controller;

import evg.testt.dto.ManagerDTO;
import evg.testt.model.Manager;
import evg.testt.model.Person;
import evg.testt.model.User;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.ManagerService;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import evg.testt.service.impl.UserServiceImpl;
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

/**
 * Created by DENNNN on 08.11.2016.
 */
@Controller
public class ManagerController {

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

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView showManagers() {
        return new ModelAndView(JspPath.MANAGER_ALL);
    }

    @RequestMapping(value = "/managerAdd")
    public ModelAndView addManager(Model model) {
        ManagerDTO manager =  new ManagerDTO();
        model.addAttribute("manager", manager);
        return new ModelAndView(JspPath.MANAGER_ADD);
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public ModelAndView saveManager(@ModelAttribute("manager") @Validated ManagerDTO managerDto, BindingResult bindingResult) {
        validator.validate(managerDto, bindingResult);


        // проверка логина на уникальность
        User u = null;
        u =  userService.findByUserLogin(managerDto.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            User newUser = new User();
                newUser.setEmail(managerDto.getEmail());
                newUser.setPassword(managerDto.getPassword());
                newUser.setLogin(managerDto.getLogin());
                newUser.setIsFirstLogin("true");

            Person newPerson = new Person();
                newPerson.setFirstName(managerDto.getFirstName());
                newPerson.setLastName(managerDto.getLastName());
                newPerson.setMiddleName(managerDto.getMiddleName());

            newPerson.setUser(newUser);

            Manager newManager = new Manager();
                newManager.setPerson(newPerson);

            try {

                managerService.insert(newManager);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showManagers();
        } else {
            return new ModelAndView(JspPath.MANAGER_ADD);
        }
    }

}
