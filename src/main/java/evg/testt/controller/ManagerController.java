package evg.testt.controller;

import evg.testt.dto.ManagerDTO;
import evg.testt.model.Manager;
import evg.testt.model.Person;
import evg.testt.model.Role;
import evg.testt.model.User;
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

import javax.persistence.NoResultException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    EWMcrmService ewMcrmService;

    @Autowired
    EWMcrmSecurityService ewMcrmSecurityService;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public ModelAndView showManagers() throws SQLException {
        List<Manager> managers = new ArrayList<>(ewMcrmService.getAllManagers());

        List<Person> persons = new ArrayList<Person>();
//        try {
        for (Manager item : managers) {
            persons.add(item.getPerson());
        }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return new ModelAndView(JspPath.MANAGER_ALL, "managers", persons);
    }

    @RequestMapping(value = "/managerAdd")
    public ModelAndView addManager(Model model) {
        ManagerDTO manager = new ManagerDTO();
        model.addAttribute("manager", manager);
        return new ModelAndView(JspPath.MANAGER_ADD);
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public ModelAndView saveManager(@ModelAttribute("manager") @Validated ManagerDTO managerDto,
                                    BindingResult bindingResult) throws SQLException {

        validator.validate(managerDto, bindingResult);

        User u;
        try{
            u = ewMcrmSecurityService.getUserByLogin(managerDto.getLogin());
        } catch(NoResultException e){
            u = null;
        }
        if (u != null) {
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            try {
                Role role = ewMcrmSecurityService.getRoleById(2);
//                        roleService.getById(2);

                Person newPerson = new Person();
                User newUser = new User();
                Manager newManager = new Manager();

                newPerson.setFirstName(managerDto.getFirstName());
                newPerson.setLastName(managerDto.getLastName());
                newPerson.setMiddleName(managerDto.getMiddleName());

                newUser.setRole(role);
                newUser.setPassword(passwordEncoder.encode(managerDto.getPassword()));
                newUser.setLogin(managerDto.getLogin());

                newManager.setPerson(newPerson);
                newManager.setUser(newUser);

            ewMcrmService.saveManager(newManager);
//            managerService.insert(newManager);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            return showManagers();
        } else {
            return new ModelAndView(JspPath.MANAGER_ADD);
        }
    }
}
