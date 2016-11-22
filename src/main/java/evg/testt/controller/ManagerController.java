package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.ManagerService;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView showManagers(@RequestParam(required = false) Integer page) {
        List<Manager> managers = Collections.EMPTY_LIST;
        int totalManagers = 0, pages = 0, currentPage = 1;

        if(page != null)
            if(page > 0)
            currentPage = page;

        try {
            totalManagers = managerService.count();

            managers = managerService.getByPage(currentPage);

            pages = ((totalManagers / pageSize)+1);

            if(totalManagers % pageSize == 0)
                pages--;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ModelAndView model = new ModelAndView(JspPath.MANAGER_ALL);
        model.addObject("managers", managers);
        model.addObject("pages", pages);

        return model;
    }

    @RequestMapping(value = "/managerAdd")
    public ModelAndView addManager(Model model) {
        PersonDTO person = new PersonDTO();
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
            return showManagers(1);
        } else {
            return new ModelAndView(JspPath.MANAGER_ADD);
        }
    }

}
