package evg.testt.controller;

import evg.testt.model.Admin;
import evg.testt.model.Person;
import evg.testt.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static javax.swing.text.StyleConstants.ModelAttribute;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @ModelAttribute
    public Admin createAdmin(){
        Admin admin = new Admin();
        admin.setPerson(new Person());
        return admin;
    }

    @RequestMapping(value = "/admin")
    public String adminPage(Model model){
        return "admin";
    }

    @RequestMapping(value = "/admins")
    public String admins(Model model) throws SQLException {
        List<Admin> admins = Collections.EMPTY_LIST;
        admins = adminService.getAll();
        model.addAttribute("admins", admins);
        return "admins/all";
    }

    @RequestMapping(value = "/admin/info", method = RequestMethod.GET)
    public String adminInfo(Model model, @RequestParam int admin_id) throws SQLException {
        Admin admin = adminService.getById(admin_id);
        model.addAttribute("admin", admin);
        return "persons/admin-info";
    }
}

