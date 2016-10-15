package evg.testt.controller;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.model.User;
import evg.testt.service.DepartmentService;
import evg.testt.service.EmployeeService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by clay on 25.09.16.
 */

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User createUser(){
        return new User();
    }

    @RequestMapping(value = "home")
    public ModelAndView homePage(){
        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/users")
    public ModelAndView showUsers(){
        List <User> users;
        try{
            users = userService.getAll();
        } catch (SQLException e){
            users = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.USERS_ALL, "users", users);
    }

    @RequestMapping(value = "/userAdd")
    public ModelAndView addUser(){
        return new ModelAndView(JspPath.USERS_ADD);
    }

    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user){
        try {
            userService.insert(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "users";
    }
}
