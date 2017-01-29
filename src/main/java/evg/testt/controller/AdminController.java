package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Admin;

import evg.testt.model.Person;
import evg.testt.model.User;
import evg.testt.service.AdminService;

import evg.testt.service.PersonDTOService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class AdminController {

    @Value("${pagination.page.size}")
    protected int pageSize;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String showAdmins(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Boolean flagSorted,
                             Model model) throws SQLException {


        int totalAdmins;
        int pages;
        int currentPage = 1;

        if (flagSorted == null) {
            flagSorted = false;
        }

        if (page != null && page > 0) {
            currentPage = page;
        }

        totalAdmins = adminService.count();

        List<Admin> admins = Collections.EMPTY_LIST;

        if (!flagSorted) {
            admins = adminService.getByPage(currentPage);
        } else {
            admins = adminService.getByPageSorted(currentPage);
        }

        pages = ((totalAdmins / pageSize) + 1);

        if (totalAdmins % pageSize == 0) {
            pages--;
        }

        model.addAttribute("admins", admins);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "admins/all";
    }

    @RequestMapping(value = "/admins/add")
    public String addAdmin(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("admins/add", request.getHeader("Referer"));
        PersonDTO person = new PersonDTO();
        model.addAttribute("admin", person);
        return "admins/add";
    }

    @RequestMapping(value = "/admins/save", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute("admin") @Valid PersonDTO personDTO,
                            BindingResult bindingResult, Model model,
                            HttpServletRequest request)
            throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null){
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {
            Admin admin = new Admin();
            admin = personDTOService.updateRegisteredUser(admin, personDTO);
            adminService.insert(admin);
            return "redirect:" + request.getSession().getAttribute("admins/add").toString();
        } else {
            return "admins/add";
        }
    }

    @RequestMapping(value = "/admins/delete")
    public String adminDelete(@RequestParam Integer id) throws SQLException {
        Admin admin = adminService.getById(id);
        adminService.delete(admin);
        return "redirect:/admins";
    }

    @RequestMapping(value = "/admins/trash")
    public String adminTrash(@RequestParam Integer id) throws SQLException {
        Admin admin = adminService.getById(id);
        adminService.trash(admin);
        return "redirect:/admins";
    }

    @RequestMapping(value = "/admins/info", method = RequestMethod.GET)
    public String adminInfo(Model model, @RequestParam int admin_id) throws SQLException {
        Admin admin = adminService.getById(admin_id);
        model.addAttribute("admin", admin);
        return "persons/admin-info";
    }
}



