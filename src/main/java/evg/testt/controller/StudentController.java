package evg.testt.controller;

import evg.testt.dto.ManagerDTO;
import evg.testt.dto.StudentDTO;
import evg.testt.model.Manager;
import evg.testt.model.Person;
import evg.testt.model.Student;
import evg.testt.model.User;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by oleksiy on 10.11.16.
 */
public class StudentController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    ManagerService managerService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PersonService personService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView showStudents() {
        List<Student> students = Collections.EMPTY_LIST;

        try {
            students = studentService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.STUDENT_ALL, "students", students);
    }
//  c DTO:

    @RequestMapping(value = "/studentAdd")
    public ModelAndView addStudent(Model model) {
        StudentDTO student =  new StudentDTO();
        model.addAttribute("student", student);
        return new ModelAndView(JspPath.STUDENT_ADD);
    }

/*//  без DTO:
    @RequestMapping(value = "/studentAdd")
    public ModelAndView addStudent() {
        return new ModelAndView(JspPath.STUDENT_ADD);
    }
//*/


    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") @Validated StudentDTO studentDto, BindingResult bindingResult) {
        validator.validate(studentDto, bindingResult);


        // проверка логина на уникальность
        User u = null;
        u =  userService.findByUserLogin(studentDto.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

            User newUser = new User();
            newUser.setEmail(studentDto.getEmail());
            newUser.setPassword(passwordEncoder.encode(studentDto.getPassword()));
            newUser.setLogin(studentDto.getLogin());
            newUser.setIsFirstLogin("true");

            Person newPerson = new Person();
            newPerson.setFirstName(studentDto.getFirstName());
            newPerson.setLastName(studentDto.getLastName());
            newPerson.setMiddleName(studentDto.getMiddleName());

            newPerson.setUser(newUser);

            Student newStudent = new Student();
            newStudent.setPerson(newPerson);

            try {
                studentService.insert(newStudent);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showStudents();
        } else {
            return new ModelAndView(JspPath.STUDENT_ADD);
        }
    }



}




