package evg.testt.controller;


import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.*;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ListPersonController {

    @Autowired
    PersonService personService;
    @Autowired
    UserService userService;

    @Autowired
    LeadService leadService;

    @Autowired
    RoleService roleService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"","/", "/home"}, method = RequestMethod.GET)
    public String showPersonOnHomePage(Principal principal, Model model) {
        List<User> users;
        List<Person> persons = null;
        Person person =null;
        try {
            persons = personService.getAll();
        } catch (SQLException e) {
            persons = Collections.emptyList();
            e.printStackTrace();
        }
        model.addAttribute("persons", persons);
        return "home";
    }

    @RequestMapping(value = "/leadsView", method = RequestMethod.GET)
    public String showLeads(Model model, Principal principal) throws SQLException {
        List<Lead> leads = leadService.getAll();
        model.addAttribute("leads", leads);
        return "listViews/leadsView";
    }

    @RequestMapping(value = "/studentsView", method = RequestMethod.GET)
    public String showStudent(@RequestParam(required = false) Integer teacher_id,
                              Model model) throws SQLException {
        List<Student> students = Collections.EMPTY_LIST;

        students = studentService.getAll();

        model.addAttribute("students", students);
        return "listViews/studentsView";
    }

    @RequestMapping(value = "/teachersView", method = RequestMethod.GET)
    public String showTeachers(Model model) throws SQLException{
        List<Person> persons = new ArrayList<Person>();

        List<Teacher> teachers = teacherService.getAll();
        for (Teacher teacher : teachers){
            persons.add(teacher.getPerson());
        }
        model.addAttribute("teachers", persons);
        return "listViews/teachersView";
    }


}
