package evg.testt.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

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
    @Autowired
    StateService stateService;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView showManagers() {
        List<Manager> managers = Collections.EMPTY_LIST;
        List<Person> persons = new ArrayList<Person>();
        try {
            managers = managerService.getAll();
            for (Manager item : managers){
                persons.add(item.getPerson());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.MANAGER_ALL, "managers", persons);
    }

    @RequestMapping(value = "/managerAdd")
    public ModelAndView addManager(Model model) {
        PersonDTO person =  new PersonDTO();
        model.addAttribute("manager", person);
        return new ModelAndView(JspPath.MANAGER_ADD);
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public ModelAndView saveManager(@ModelAttribute("manager") @Validated PersonDTO personDTO, BindingResult bindingResult) {
        validator.validate(personDTO, bindingResult);
        // проверка логина на уникальность
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            try {

                UserRole roleId = UserRole.ROLE_MANAGER;

                Role role = roleService.getById(roleId.getRoleId());

                Person newPerson = new Person();
                User newUser = new User();
                Manager newManager = new Manager();
                Email email = new Email();

                email.setEmail(personDTO.getEmail());

                newPerson.setFirstName(personDTO.getFirstName());
                newPerson.setLastName(personDTO.getLastName());
                newPerson.setMiddleName(personDTO.getMiddleName());
                newPerson.setEmail(email);

                newUser.setRole(role);
                newUser.setPassword(passwordEncoder.encode(personDTO.getPassword()));
                newUser.setLogin(personDTO.getLogin());

                newManager.setPerson(newPerson);
                newManager.setUser(newUser);

                managerService.insert(newManager);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showManagers();
        } else {
            return new ModelAndView(JspPath.MANAGER_ADD);
        }
    }

    @RequestMapping(value = "/managerDelete")
    public ModelAndView deleteManager(@RequestParam Integer id) {
        try {

            Person person = personService.getById(id);
            personService.delete(person);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showManagers();
    }

}
