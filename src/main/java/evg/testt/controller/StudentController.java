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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import evg.testt.model.Role;
import evg.testt.service.RoleService;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by oleksiy on 10.11.16.
 */
@Controller
public class StudentController {

    @Autowired
    SpringOvalValidator validator;

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
        List<Person> persons = new ArrayList<Person>();

        try {
            students = studentService.getAll();
            for (Student item : students){
                persons.add(item.getPerson());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.STUDENT_ALL, "students", students);
    }
//  c DTO:

    @RequestMapping(value = "/studentAdd") // вход при нажатии кнопки "добавить студетна"
    public ModelAndView addStudent(Model model) { // метод, генерирующий страницу, на которой можно "добавить студента" (в него приходит "модель")
        StudentDTO student =  new StudentDTO(); // создание "промежуточного" объекта для передачи данных
        model.addAttribute("student", student); // в модель добавляется атрибут с именем "student" и соотсетствующим DTO-шником?
        return new ModelAndView(JspPath.STUDENT_ADD); // возвращает страницу, на которой можно вводить данные
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

            try {
                Role role = roleService.getById(2);

                Person newPerson = new Person();
                User newUser = new User();
                Student newStudent = new Student();

                newPerson.setLastName(studentDto.getLastName());
                newPerson.setFirstName(studentDto.getFirstName());
                newPerson.setMiddleName(studentDto.getMiddleName());

                newUser.setRole(role);
                newUser.setPassword(passwordEncoder.encode(studentDto.getPassword()));
                newUser.setLogin(studentDto.getLogin());

                newStudent.setPerson(newPerson);
                newStudent.setUser(newUser);

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




