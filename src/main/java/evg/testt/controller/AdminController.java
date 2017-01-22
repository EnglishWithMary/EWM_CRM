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

    @Autowired
    private AdminService adminService;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    private UserService userService;

    @Value("${pagination.page.size}")
    protected int pageSize;

//    @ModelAttribute
//    public Admin createAdmin(){
//        Admin admin = new Admin();
//        admin.setPerson(new Person());
//        return admin;
//    }
//
//    @RequestMapping(value = "/admin")
//    public String adminPage(Model model){
//        return "admin";
//    }
//
//    @RequestMapping(value = "/admins")
//    public String admins(Model model) throws SQLException {
//        List<Admin> admins = Collections.EMPTY_LIST;
//        admins = adminService.getAll();
//        model.addAttribute("admins", admins);
//        return "admins/all";
//    }



        @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String showAdmins(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Boolean flagSorted,
                               Model model) throws SQLException {

        if (flagSorted == null) flagSorted = false;

        int totalManagers = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        totalManagers = adminService.count();

        List<Admin> admins = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            admins = adminService.getByPage(currentPage);
        } else {
            admins = adminService.getByPageSorted(currentPage);
        }

        pages = ((totalManagers / pageSize) + 1);

        if (totalManagers % pageSize == 0)
            pages--;

        model.addAttribute("admins", admins);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "admins/all";
    }

    @RequestMapping(value = "/adminAdd")
    public String addAdmin(Model model,
                           HttpServletRequest request) {
        request.getSession().setAttribute("addAdmin", request.getHeader("Referer"));
        PersonDTO person = new PersonDTO();
        model.addAttribute("admin", person);
        return "admins/add";
    }

    @RequestMapping(value = "/adminSave", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute("admin") @Valid PersonDTO personDTO,
                              BindingResult bindingResult, Model model,
                            HttpServletRequest request) throws SQLException, ParseException {


        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Admin admin = new Admin();
            admin = personDTOService.updateRegisteredUser(admin, personDTO);
            adminService.insert(admin);

            return "redirect:"+request.getSession().getAttribute("addAdmin").toString();
        } else {
            return "admins/add";
        }
    }

    @RequestMapping(value = "/adminDelete")
    public String adminDelete(@RequestParam Integer id) throws SQLException {
      Admin admin =adminService.getById(id);
        adminService.delete(admin);
        return "redirect:/admins";
    }

    @RequestMapping(value = "/adminTrash")
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



