package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.service.impl.BaseService;
import evg.testt.service.impl.PersonDTOServiceImpl;
import evg.testt.service.impl.StudentLevelHistoryServiceImpl;
import evg.testt.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class StudentController {

//    @Autowired
//    private SpringOvalValidator validator;
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
    @Autowired
    private StudentLevelHistoryService studentLevelHistoryService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudents(Model model,@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer teacher_id,
                               @RequestParam(required = false) List<Integer> group_id_list
                               ,@RequestParam(required = false) String studentSortByDate
    ) throws SQLException {

        int totalStudents = 0, pages = 0, currentPage = 1;

        if (page != null){
            if (page > 0) currentPage = page;
        } else{
            page=currentPage;
        }

        totalStudents = studentService.countByFilter(teacher_id, group_id_list);

        List<Student> students = studentService.getStudentsPageWithFilters(
                page,teacher_id, group_id_list, studentSortByDate);

        pages = ((totalStudents / pageSize) + 1);
        if (totalStudents % pageSize == 0) {
            pages--;
        }

        model.addAttribute("teacherId", teacher_id);
        model.addAttribute("sortDirection", studentSortByDate);
        model.addAttribute("groupIdList", group_id_list);
        model.addAttribute("students", students);
        model.addAttribute("pages", pages);
        model.addAttribute("groups",groupService.getAll());
        model.addAttribute("teachers",teacherService.getAll());
        return "students/all";
    }

    @RequestMapping(value = "/studentAdd")
    public String addStudent(Model model) throws SQLException {
        PersonDTO person = new PersonDTO();

        List<Teacher> teachers = teacherService.getAll();

        List<Group> groups = groupService.getAll();

        model.addAttribute("student", person).addAttribute("teachers", teachers);
        model.addAttribute("groups", groups);
        return "students/add";
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") @Valid PersonDTO personDTO,
                              BindingResult bindingResult, Model model,
                              @RequestParam(required = false) Integer teacher_id,
                              @RequestParam(required = false) Integer group_id) throws SQLException, ParseException {
//        validator.validate(personDTO, bindingResult);

        User u = userService.findByUserLogin(personDTO.getLogin());
        Teacher teacher = null;
        Group group = null;
        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Student student = new Student();
            student = personDTOService.updateRegisteredUser(student, personDTO);



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

            model.addAttribute("groups",groupService.getAll());
            model.addAttribute("teachers",teacherService.getAll());
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
        return "redirect:/students";
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

    @RequestMapping(value = "/studentTestingResults")
    public String studentEditLevel(@RequestParam Integer id, Model model) throws SQLException {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        model.addAttribute("person", student.getPerson());
        model.addAttribute("checkpointDate", new Date());
        return "students/testingResults";
    }

    @RequestMapping(value = "/saveTestingResults", method = RequestMethod.POST)
    public String saveTestingResults(@ModelAttribute("studentLevelHistory") StudentLevelHistory studentLevelHistory,
                                     @RequestParam Integer student_id)
            throws SQLException, ParseException {

        Student student = studentService.getById(student_id);

        studentLevelHistory.setStudent(student);

        studentLevelHistoryService.insert(studentLevelHistory);

        return "redirect:/students";
    }

    public Date getDateFromString(String dateFromForm) throws ParseException {
        if (dateFromForm == "") dateFromForm = "2001-01-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateFromForm);
        return date;
    }

    @RequestMapping(value = "/studentsSortedByGroup", method = RequestMethod.POST)
    public String showSortedStudent(Model model, @RequestParam(required = false) List<Integer> groupIdList)
            throws SQLException {
        List<Group> groups = groupService.getAll();
        List<Teacher> teachers = teacherService.getAll();
        List<Student> students = new ArrayList<>();
        if (groupIdList!=null && groupIdList.size()>0) {
            if (groupIdList.contains(-1)) students.addAll(studentService.getStudentsWithoutGroup());
            if (groupIdList.contains(0)) students.addAll(studentService.getAllStudentsWithGroup());
            else{
                for (Integer id : groupIdList)
                    if (id > 0)
                        students.addAll(studentService.getAllByGroup(id));
            }
        }else{
            students = studentService.getAll();
        }
        model.addAttribute("groups", groups)
        .addAttribute("students", students)
        .addAttribute("teachers", teachers);
        return "students/all";

    }

    @RequestMapping(value = "/student/info", method = RequestMethod.GET)
    public String studentInfo(Model model, @RequestParam int student_id) throws SQLException {
        Student student = studentService.getById(student_id);
        model.addAttribute("student", student);
        return "persons/student-info";
    }
}