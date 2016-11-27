package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

@Controller
@PropertySource(value = "classpath:standard.properties")
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

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView showManagers(@RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Boolean flagSorted
    ) {
        if (flagSorted == null) flagSorted = false;

        List<Manager> managers = Collections.EMPTY_LIST;
        int totalManagers = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        try {
            totalManagers = managerService.count();

            if (flagSorted == false) {
                managers = managerService.getByPage(currentPage);
            } else {
                managers = managerService.getByPageSorted(currentPage);
            }

            pages = ((totalManagers / pageSize) + 1);

            if (totalManagers % pageSize == 0)
                pages--;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ModelAndView model = new ModelAndView(JspPath.MANAGER_ALL);
        model.addObject("managers", managers);
        model.addObject("pages", pages);
        model.addObject("flagSorted", flagSorted);
        return model;
    }

    @RequestMapping(value = "/managerAdd")
    public ModelAndView addManager(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("manager", person);
        return new ModelAndView(JspPath.MANAGER_ADD);
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public ModelAndView saveManager(@ModelAttribute("manager") @Validated PersonDTO personDTO,
                                    BindingResult bindingResult) {
        validator.validate(personDTO, bindingResult);
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
                newPerson.setState(stateService.getById(PersonState.STATE_ACTIVE.getStateId()));

                newUser.setRole(role);
                newUser.setPassword(passwordEncoder.encode(personDTO.getPassword()));
                newUser.setLogin(personDTO.getLogin());

                newManager.setPerson(newPerson);
                newManager.setUser(newUser);

                managerService.insert(newManager);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showManagers(1, false);
        } else {
            return new ModelAndView(JspPath.MANAGER_ADD);
        }
    }

    @RequestMapping(value = "/managerDelete")
    public ModelAndView deleteManager(@RequestParam Integer id) {
        try {

            Manager manager = managerService.getById(id);
            Person person = manager.getPerson();
            personService.delete(person);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showManagers(1, false);
    }

}
