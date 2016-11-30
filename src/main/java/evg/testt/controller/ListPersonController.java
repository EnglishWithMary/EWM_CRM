package evg.testt.controller;

import evg.testt.model.Person;
import evg.testt.service.EWMcrmSecurityService;
import evg.testt.service.PersonService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class ListPersonController {

    @Autowired
    PersonService personService;

    @Autowired
    EWMcrmSecurityService ewMcrmSecurityService;

    @RequestMapping(value = {"","/","/home"}, method = RequestMethod.GET)
    public String showPerson(Model model) {
        List<Person> persons ;
        try {
            persons = personService.getAll();
        } catch (SQLException e) {
            persons = Collections.emptyList();
            e.printStackTrace();
        }
        model.addAttribute("persons", persons);
        return "home";
    }
}
