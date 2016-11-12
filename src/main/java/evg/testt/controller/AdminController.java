package evg.testt.controller;

import evg.testt.model.Admin;
import evg.testt.model.Person;
import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.service.EWMcrmService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    EWMcrmService ewMcrmService;

    @ModelAttribute
    public Admin createAdmin(){
        Admin admin = new Admin();
        admin.setPerson(new Person());
        return admin;
    }

    @RequestMapping(value = "/admin")
    public String adminPage(Model model){
        List<Admin> admins = new ArrayList<Admin>(ewMcrmService.getAllAdmins());
        model.addAttribute("admins", admins);
        return "admin";
    }

    @RequestMapping(value = "/adminAdd", method = RequestMethod.GET)
    public String adminAdd(Model model){
        model.addAttribute("admin", createAdmin());
        return "adminAdd";
    }

    @RequestMapping(value = "/adminAdd", method = RequestMethod.POST)
    public String adminSave(@ModelAttribute (value = "admin") @Validated Admin admin,
                            BindingResult result, Model model){
        if(result.hasErrors()){
            return "adminAdd";
        }
        ewMcrmService.saveAdmin(admin);
        return "redirect:/admin";
    }

}
