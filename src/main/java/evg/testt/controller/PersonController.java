package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Person;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.PersonService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    PersonService personService;

    /*@Autowired
    GroupService groupService;

    @Autowired
    TeacherService teacherService;*/

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView showGroups() {
        List<Person> persons = Collections.EMPTY_LIST;
        Person p =new Person();
        p.getId();
        try {
            persons=personService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.PERSON_ALL, "persons", persons);
        modelAndView.addObject("personFilter", new PersonDTO());
        return modelAndView;
    }

}
