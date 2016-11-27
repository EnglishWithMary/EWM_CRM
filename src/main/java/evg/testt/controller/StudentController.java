package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
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

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudent(@RequestParam(required = false) Integer teacher_id,
                              Model model) throws SQLException {
        List<Student> students = Collections.EMPTY_LIST;
        List<Teacher> teachers = teacherService.getAll();

        if (teacher_id != null) {
            if (teacher_id > 0) {
                students = studentService.getAllByTeacher(teacher_id);
            } else if (teacher_id == -1) {
                students = studentService.getStudentsWithoutTeacher();
            }
        } else {
            students = studentService.getAll();
        }
        model.addAttribute("students", students)
                .addAttribute("teachers", teachers);
        return "students/all";
    }

    @RequestMapping(value = "/studentAdd")
    public String addStudent(Model model) throws SQLException {
        PersonDTO person = new PersonDTO();
        List<Teacher> teachers = teacherService.getAll();
        model.addAttribute("student", person)
                .addAttribute("teachers", teachers);
        return "students/add";
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") @Validated PersonDTO personDTO,
                                    BindingResult bindingResult, Model model,
                                    @RequestParam(required = false) Integer teacher_id) throws SQLException {
        validator.validate(personDTO, bindingResult);
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");
        if (!bindingResult.hasErrors()) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
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

                if (teacher_id != null && teacher_id > 0) {
                    teacher = teacherService.getById(teacher_id);
                    newStudent.setTeacher(teacher);
                }

                studentService.insert(newStudent);

            return "redirect:/students";
        } else {
            return "students/add";
        }
    }

    @RequestMapping(value = "/studentSortByDate", method = RequestMethod.POST)
    public String filterStudents(Model model) throws SQLException{
        List<Person> persons = new ArrayList<Person>();
        List<Student> students = studentService.getSortedByRegistrationDate();
            for (Student item : students) {
                persons.add(item.getPerson());
            }
            model.addAttribute("students", students);
        return "students/all";
    }
}