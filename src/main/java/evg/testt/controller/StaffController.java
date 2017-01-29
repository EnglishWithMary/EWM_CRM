package evg.testt.controller;

import evg.testt.model.Person;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.LinkedList;

@Controller
public class StaffController {
    @Value("${pagination.page.size}")
    protected int pageSize;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    AdminService adminService;
    @Autowired
    ManagerService managerService;
    @Autowired
    PersonService personService;

    @RequestMapping(value = "/personnel", method = RequestMethod.GET)
    public String showGroups(Model model, @RequestParam(required = false) Integer page) throws SQLException {

        LinkedList staffs = new LinkedList<>();

        staffs.addAll(adminService.getAll());
        staffs.addAll(managerService.getAll());
        staffs.addAll(teacherService.getAll());

        model.addAttribute("staffs", staffs);
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
