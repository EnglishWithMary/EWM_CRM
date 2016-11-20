package evg.testt.controller;

import evg.testt.model.Admin;
import evg.testt.model.Person;
import evg.testt.service.EWMcrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
        List<Admin> admins = new ArrayList<>(ewMcrmService.getAllAdmins());
        model.addAttribute("admins", admins);
        return "admin";
    }

    @RequestMapping(value = "/adminAdd", method = RequestMethod.GET)
    public String adminAdd(){
        /**
         * TODO: add logic
         */
        return "adminAdd";
    }

    @RequestMapping(value = "/adminAdd", method = RequestMethod.POST)
    public String adminSave(){
        /**
         * TODO: add logic
         */
        return "admin";
    }


}
