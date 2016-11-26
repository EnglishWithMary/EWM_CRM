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
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    StateService stateService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView showStudent(@RequestParam(required = false) Integer teacher_id) {
        List<Student> students = Collections.EMPTY_LIST;
        List<Teacher> teachers = Collections.EMPTY_LIST;

        try {
            teachers = teacherService.getAll();

            if(teacher_id != null)
            {
                if(teacher_id > 0)
                    students = studentService.getAllByTeacher(teacher_id);
                else if(teacher_id == -1)
                    students = studentService.getStudentsWithoutTeacher();
            }
            else
                students = studentService.getAll();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ModelAndView(JspPath.STUDENT_ALL, "students", students).addObject("teachers", teachers);
    }

    @RequestMapping(value = "/studentAdd")
    public ModelAndView addStudent(Model model) {
        PersonDTO person = new PersonDTO();
        List<Teacher> teachers = Collections.EMPTY_LIST;

        try {
            teachers = teacherService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView(JspPath.STUDENT_ADD);
        model.addAttribute("student", person);
        model.addAttribute("teachers", teachers);
        return mav;
    }

        @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
        public ModelAndView saveStudent (@ModelAttribute("student") @Validated PersonDTO personDTO,
                                         BindingResult bindingResult,
                                         @RequestParam(required = false) Integer teacher_id){
            validator.validate(personDTO, bindingResult);
            // проверка логина на уникальность
            User u = userService.findByUserLogin(personDTO.getLogin());
            if (u != null)
                bindingResult.rejectValue("login", "1", "Login already exist.");

            if (!bindingResult.hasErrors()) {

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                try {

                    UserRole roleId = UserRole.ROLE_STUDENT;
                    Role role = roleService.getById(roleId.getRoleId());

                    Person newPerson = new Person();
                    User newUser = new User();
                    Student newStudent = new Student();
                    Teacher teacher;

                    newPerson.setFirstName(personDTO.getFirstName());
                    newPerson.setLastName(personDTO.getLastName());
                    newPerson.setMiddleName(personDTO.getMiddleName());
                    newPerson.setComments(personDTO.getComments());

                    newUser.setRole(role);
                    newUser.setPassword(passwordEncoder.encode(personDTO.getPassword()));
                    newUser.setLogin(personDTO.getLogin());
                    newStudent.setPerson(newPerson);
                    newStudent.setUser(newUser);

                    if(teacher_id != null && teacher_id  > 0) {
                        teacher = teacherService.getById(teacher_id);
                        newStudent.setTeacher(teacher);
                    }

                    studentService.insert(newStudent);

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return showStudent();
        } else {
            return new ModelAndView(JspPath.STUDENT_ADD);
        }
    }
    @RequestMapping(value = "/studentDelete")
    public ModelAndView deleteStudent(@RequestParam Integer id) {
        try {

            Person person = personService.getById(id);
            personService.delete(person);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showStudent();
    }

    @RequestMapping(value = "/studentSortByDate", method = RequestMethod.POST)
    public ModelAndView filterStudents() {
        List<Student> students = Collections.EMPTY_LIST;
        List<Person> persons = new ArrayList<Person>();
        try {
            students=studentService.getSortedByRegistrationDate();
            for (Student item : students){
                persons.add(item.getPerson());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.STUDENT_ALL, "students", students);
        return modelAndView;
    }
}