package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Person;
import evg.testt.model.User;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;
    @Autowired
    RoleService roleService;

    @ModelAttribute("user")
    public User createUser() {
        return new User();
    }

    @RequestMapping(value = {"","/","/home"})
    public String homePage(Model model, Principal principal) throws SQLException {

        if (principal != null) {
            Person person = personService.getPersonByUserLogin(principal.getName());
            model.addAttribute("person", person);
        }
        return "home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<User> users;
        try {
            users = userService.getAll();
        } catch (SQLException e) {
            users = Collections.emptyList();
            e.printStackTrace();
        }
        model.addAttribute("users", users);
        return "users/all";
    }

    @RequestMapping(value = "/users/add")
    public String addUser(Model model) {
        PersonDTO person =  new PersonDTO();
        model.addAttribute("user", person);
        return "users/add";
    }

    @RequestMapping(value = "/users/save", method = RequestMethod.POST)
    public String saveUser(Model model, @Valid @ModelAttribute("user")  User user, BindingResult bindingResult) {

        User u =  userService.findByUserLogin(user.getLogin());
        if (u != null)
        bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {
            try {
                userService.insert(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "users/all";
        } else {
            return "users/add";
        }
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model,
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {

        if(!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)){
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("error", "Invalid username or password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }
}