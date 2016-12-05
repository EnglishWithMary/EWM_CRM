package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
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
    private SpringOvalValidator validator;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PersonService personService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PersonDTOService personDTOService;
    @Autowired
    private GroupService groupService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudent(@RequestParam(required = false) Integer teacher_id,
                              @RequestParam(required = false) Integer group_id,
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
        model.addAttribute("groups", groups);
        return "students/add";
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute("student") @Validated PersonDTO personDTO,
                                    BindingResult bindingResult, Model model
                                    @RequestParam(required = false) Integer teacher_id,
                                    @RequestParam(required = false) Integer group_id) throws SQLException  {
        validator.validate(personDTO, bindingResult);
        // проверка логина на уникальность
        User u = userService.findByUserLogin(personDTO.getLogin());
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Student newStudent = personDTOService.buildPerson(personDTO).getStudent();
            Teacher teacher;
            Group group;

            if (teacher_id != null && teacher_id > 0) {
                teacher = teacherService.getById(teacher_id);
                newStudent.setTeacher(teacher);
            }
            if (group_id != null && group_id > 0) {
                group = groupService.getById(group_id);
                newStudent.setGroup(group);

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

    @RequestMapping(value = "/studentDelete")
    public String studentDelete(@RequestParam Integer id) throws SQLException {
        Student student = studentService.getById(id);
        studentService.delete(student);
        return "students/all";
    }

    @RequestMapping(value = "/studentTrash")
    public String studentTrash(@RequestParam Integer id) throws SQLException {
        Student student = studentService.getById(id);
        studentService.trash(student);
        return "students/all";
    }

    @RequestMapping(value = "/studentsSortedByGroup", method = RequestMethod.GET)
    public ModelAndView showSortedStudent(@RequestParam(required = false) Integer group_id) {
        {
            List<Student> students = Collections.EMPTY_LIST;
            List<Group> groups = Collections.EMPTY_LIST;

            try {
                groups = groupService.getAll();

                if (group_id != null) {
                    if (group_id > 0)
                        students = studentService.getAllByGroup(group_id);
                    else if (group_id == -1)
                        students = studentService.getStudentWithoutGroup();
                } else
                    students = studentService.getAll();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return new ModelAndView(JspPath.STUDENT_ALL, "students", students)
                    .addObject("groups", groups);
        }
    }
}