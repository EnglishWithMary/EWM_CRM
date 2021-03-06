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
    @Value("${pagination.page.size}")
    protected int pageSize;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @Autowired
    PersonService personService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    private PersonnelService personnelService;

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

    @RequestMapping(value = "/personnel/trashed")
    public String adminTrash(@RequestParam(required = false) Integer id) throws SQLException {
        Person admin = personService.getById(id);
        admin.getState().setState("TRASHED");
        personService.update(admin);
        return "redirect:/personnel";
    }
}
