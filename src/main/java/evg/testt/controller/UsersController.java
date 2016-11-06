package evg.testt.controller;

import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
 * TODO: add functionality to interact with User - CRUD
 */

@Controller
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    SpringOvalValidator validator;

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = {"","/","/home"})
    public String homePage() {
        return "home";
    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public ModelAndView showUsersFromPost() {
//        return showUsers();
//    }
//
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUsers() {
        List<User> users;
        try {
            users = userService.getAll();
        } catch (SQLException e) {
            users = Collections.emptyList();
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.USERS_ALL, "users", users);
    }

    @RequestMapping(value = "/userAdd")
    public ModelAndView addUser() {
        return new ModelAndView(JspPath.USERS_ADD);
    }

    @RequestMapping(value = "/userSave", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult) {
        validator.validate(user, bindingResult);

        User u = null;
        u =  userService.findByUserLogin(user.getLogin());
        if (u != null)
        bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {
            try {
                user.setIsFirstLogin("true");
                userService.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showUsers();
        } else {
            return new ModelAndView(JspPath.USERS_ADD);
        }
    }
//
//    @RequestMapping(value = "/userAddRole", method = RequestMethod.GET)
//    public ModelAndView addRole(@RequestParam int id) {
//        User user;
//        ModelAndView model;
//        try {
//            user = userService.getById(id);
//        } catch (SQLException e) {
//            user = null;
//            e.printStackTrace();
//        }
//        if (user.getRoles() != null) {
//            return showUsers();
//        } else {
//            model = new ModelAndView(JspPath.USERS_ADD_ROLE);
//        }
//        model.addObject("role", new Role());
//        model.addObject("user_id", id);
//        return model;
//    }

//    @RequestMapping(value = "/userAddRole", method = RequestMethod.POST)
//    public String saveRole(@ModelAttribute("role") Role role, @RequestParam int id) {
//        User user;
//        try {
//            user = userService.getById(id);
//            user.setRoles(role);
//            role.setUsers(user);
//            roleService.update(role);
//            userService.update(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "forward:/users";
//    }

//    @RequestMapping(value = "userDel")
//    public String deleteUser(@RequestParam int id) {
//        User user;
//        Role role;
//        try {
//            user = userService.getById(id);
//            role = user.getRoles();
//            user.setRoles(null);
//            roleService.delete(role);
//            userService.update(user);
//            userService.delete(user);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return "forward:/users";
//    }
}