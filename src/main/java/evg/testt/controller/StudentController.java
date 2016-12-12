package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class StudentController {

    @Autowired
    private SpringOvalValidator validator;
    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PersonDTOService personDTOService;
    @Autowired
    private GroupService groupService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudents(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Boolean flagSorted,
                               Model model) throws SQLException {

        if (flagSorted == null) flagSorted = false;

        int totalStudents = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        totalStudents = studentService.count();

        List<Student> students = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            students = studentService.getByPage(currentPage);
        } else {
            students = studentService.getByPageSorted(currentPage);
        }

        pages = ((totalStudents / pageSize) + 1);

        if (totalStudents % pageSize == 0) {
            pages--;
        }
        model.addAttribute("students", students);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "students/all";
    }

    @RequestMapping(value = "/studentAdd")
    public String addStudent(Model model) throws SQLException {
        PersonDTO person = new PersonDTO();

        List<Teacher> teachers = teacherService.getAll();

        List<Group> groups = groupService.getAll();

        model.addAttribute("student", person)
                .addAttribute("teachers", teachers);
        model.addAttribute("groups", groups);
        return "students/add";
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") @Validated PersonDTO personDTO,
                              BindingResult bindingResult, Model model,
                              @RequestParam(required = false) Integer teacher_id,
                              @RequestParam(required = false) Integer group_id) throws SQLException, ParseException {
        validator.validate(personDTO, bindingResult);

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Student student = new Student();
            student = personDTOService.updateRegisteredUser(student, personDTO);

            Teacher teacher;
            Group group;

            if (teacher_id != null && teacher_id > 0) {
                teacher = teacherService.getById(teacher_id);
                student.setTeacher(teacher);
            }
            if (group_id != null && group_id > 0) {
                group = groupService.getById(group_id);
                student.setGroup(group);
            }

            studentService.insert(student);

            return "redirect:/students";
        } else {
            return "students/add";
        }
    }

    @RequestMapping(value = "/studentSortByDate", method = RequestMethod.POST)
    public String filterStudents(Model model) throws SQLException {

        List<Student> students = studentService.getSortedByRegistrationDate();
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();

        model.addAttribute("students", students).addAttribute("teachers", teachers)
                .addAttribute("groups", groups);
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


    @RequestMapping(value = "/studentSortByTeacher", method = RequestMethod.POST)
    public String showSortedByTeacher(@RequestParam(required = false) Integer teacher_id, Model model) throws SQLException {

        List<Student> students = Collections.EMPTY_LIST;
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();

        if (teacher_id == null) {
            students = studentService.getAll();
        } else if (teacher_id == -1) {
            students = studentService.getStudentsWithoutTeacher();
        } else if (teacher_id > 0) {
            students = studentService.getAllByTeacher(teacher_id);
        }
        model.addAttribute("students", students).addAttribute("teachers", teachers)
                .addAttribute("groups", groups);
        return "students/all";
    }


    @RequestMapping(value = "/studentsSortedByGroup", method = RequestMethod.GET)
    public String showSortedStudent(Model model, @RequestParam(required = false) Integer group_id)
            throws SQLException {

        List<Student> students = Collections.EMPTY_LIST;
        List<Group> groups = groupService.getAll();
        List<Teacher> teachers = teacherService.getAll();

        if (group_id == null) {
            students = studentService.getAll();
        } else if (group_id == -1) {
            students = studentService.getStudentWithoutGroup();
        } else if (group_id > 0) {
            students = studentService.getAllByGroup(group_id);
        }

        model.addAttribute("groups", groups).addAttribute("students", students)
                .addAttribute("teachers", teachers);

        return "students/all";

    }

    @RequestMapping(value = "/student/info")
    public String studentInfo(Model model, @RequestParam int student_id) throws SQLException {

        Student student = studentService.getById(student_id);

        model.addAttribute("student", student);

        return "persons/student-info";
    }
}
