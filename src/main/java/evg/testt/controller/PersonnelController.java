package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Controller
public class PersonnelController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @Autowired
    PersonService personService;
    @Autowired
    private PersonnelService personnelService;
    @Value("${pagination.page.size}")
    protected int pageSize;


    @RequestMapping(value = "/personnel", method = RequestMethod.GET)
    public String showGroups(Model model, @RequestParam(required = false) Integer page) throws SQLException {

        page = (page != null && page > 1) ? page : 1;

        int count = personnelService.count();
        int pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        List<Personnel> personnel = personnelService.getAllSortedAndPaginated(page);
        model.addAttribute("personnel", personnel);
        model.addAttribute("pages", pages);
        return "persons/all";
    }

    @RequestMapping(value = "/personnel/addAdmins")
    public String addAdmin(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("adminWithPersonnel", person);
        return "personnel/addAdmin";
    }

    @RequestMapping(value = "/personnel/saveAdmin", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute("adminWithPersonnel") @Valid PersonDTO personDTO,
                            BindingResult bindingResult, Model model) throws SQLException, ParseException {


        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null) {
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {
            Admin admin = new Admin();
            admin = personDTOService.updateRegisteredUser(admin, personDTO);
            adminService.insert(admin);
            return "redirect:/persons";
        } else {
            return "personnel/addAdmin";
        }
    }

    @RequestMapping(value = "/personnel/trashed")
    public String adminTrash(@RequestParam(required = false) Integer id) throws SQLException {
        Person admin = personService.getById(id);
        admin.getState().setState("TRASHED");
        personService.update(admin);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/personnel/addManagers")
    public String addManagerPersonnel(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("managerWithPersonnel", person);
        return "personnel/addManager";
    }

    @RequestMapping(value = "/personnel/saveManager", method = RequestMethod.POST)
    public String saveManagerPersonnel(@ModelAttribute("managerWithPersonnel") @Valid PersonDTO personDTO,
                                       BindingResult bindingResult, Model model) throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null) {
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {
            Manager manager = new Manager();
            manager = personDTOService.updateRegisteredUser(manager, personDTO);
            managerService.insert(manager);

            return "redirect:/personnel";
        } else {
            return "personnel/addManager";
        }
    }

    @RequestMapping(value = "/personnel/addTeachers")
    public String addTeacher(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("teacherWithPersonnelAdd", person);
        return "personnel/addTeacher";
    }

    @RequestMapping(value = "/personnel/saveTeacher", method = RequestMethod.POST)
    public String saveTeacher(@Valid @ModelAttribute("teacherWithPersonnelAdd") PersonDTO personDTO,
                              BindingResult bindingResult,
                              Model model) throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null) {
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {
            Teacher teacher = new Teacher();
            teacher = personDTOService.updateRegisteredUser(teacher, personDTO);
            teacherService.insert(teacher);

            return "redirect:/persons";
        } else {
            return "personnel/addTeacher";
        }
    }
}
