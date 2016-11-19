package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.util.JspPath;
import org.bouncycastle.jcajce.provider.symmetric.TEA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    SpringOvalValidator validator;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PersonService personService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView showStudent() {
        List<Student> students = Collections.EMPTY_LIST;
        List<Person> persons = new ArrayList<Person>();
        try {
            students = studentService.getAll();
            for (Student item : students){
                persons.add(item.getPerson()); // persons.add(student.getPerson())
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.STUDENT_ALL, "students", persons);
    }

    @RequestMapping(value = "/studentAdd")
    public ModelAndView addStudent(Model model) {
        PersonDTO person =  new PersonDTO();
        List<Teacher> teachers = Collections.EMPTY_LIST; // пустой список тичеров
        List<Person> persons = new ArrayList<Person>(); // непустой список персонов
        try {
            teachers = teacherService.getAll(); // заполняет список тичеров
            for (Teacher item : teachers) { // для каждого тичера в списке
                persons.add(item.getPerson());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
         model.addAttribute("student", person);
         model.addAttribute("teacher", teachers);
        return new ModelAndView(JspPath.STUDENT_ADD, "teachers", persons);
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") @Validated PersonDTO personDTO, BindingResult bindingResult) {
        validator.validate(personDTO, bindingResult);
        // проверка логина на уникальность
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            try {

                Person newPerson = new Person();
                Student newStudent = new Student();

                newPerson.setFirstName(personDTO.getFirstName());
                newPerson.setLastName(personDTO.getLastName());
                newPerson.setMiddleName(personDTO.getMiddleName());
                newPerson.setComment(personDTO.getComment());

                newStudent.setPerson(newPerson);

                studentService.insert(newStudent);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showStudent();
        } else {
            return new ModelAndView(JspPath.STUDENT_ADD);
        }
    }

}
