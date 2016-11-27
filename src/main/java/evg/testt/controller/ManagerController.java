package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.ManagerService;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
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

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

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
    public String showManagers(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Boolean flagSorted,
                               Model model) throws SQLException {

        if (flagSorted == null) flagSorted = false;

        int totalManagers = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        totalManagers = managerService.count();

        List<Manager> managers = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            managers = managerService.getByPage(currentPage);
        } else {
            managers = managerService.getByPageSorted(currentPage);
        }

        pages = ((totalManagers / pageSize) + 1);

        if (totalManagers % pageSize == 0)
            pages--;

        model.addAttribute("managers", managers);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "managers/all";
    }

    @RequestMapping(value = "/managerAdd")
    public String addManager(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("manager", person);
        return "managers/add";
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public String saveManager(@ModelAttribute("manager") @Validated PersonDTO personDTO,
                              BindingResult bindingResult, Model model) throws SQLException {
        validator.validate(personDTO, bindingResult);
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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
            return "redirect:/managers";
        } else {
            return "manager/add";
        }
    }
}
