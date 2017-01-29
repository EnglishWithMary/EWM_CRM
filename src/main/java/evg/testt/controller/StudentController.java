package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Autowired
    private PersonDTOService personDTOService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CardService cardService;
    @Autowired
    private StudentLevelHistoryService studentLevelHistoryService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudents(Model model, @RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Integer teacher_id,
                               @RequestParam(required = false) List<Integer> group_id_list
            , @RequestParam(required = false) String studentSortByDate
    ) throws SQLException {

        int totalStudents;
        int pages;
        int currentPage = 1;

        if (page != null) {
            if (page > 0) currentPage = page;
        } else {
            page = currentPage;
        }

        totalStudents = studentService.countByFilter(teacher_id, group_id_list);

        List<Student> students = studentService.getStudentsPageWithFilters(
                page, teacher_id, group_id_list, studentSortByDate);

        pages = ((totalStudents / pageSize) + 1);
        if (totalStudents % pageSize == 0) {
            pages--;
        }

        model.addAttribute("teacherId", teacher_id);
        model.addAttribute("sortDirection", studentSortByDate);
        model.addAttribute("groupIdList", group_id_list);
        model.addAttribute("students", students);
        model.addAttribute("pages", pages);
        model.addAttribute("groups", groupService.getAll());
        model.addAttribute("teachers", teacherService.getAll());
        return "students/all";
    }

    @RequestMapping(value = "/students/add")
    public String addStudent(Model model,
                             @RequestParam(required = false) Integer cardId,
                             @RequestParam(required = false) Integer personId) throws SQLException {

        PersonDTO personDTO = personDTOService.getUpdatedPersonDTO(new PersonDTO(), personId, cardId);

        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();

        model.addAttribute("student", personDTO);
        model.addAttribute("teachers", teachers);
        model.addAttribute("groups", groups);
        model.addAttribute("cards", cardService.getCards(Pipe.STUDENT_PIPE));
        return "students/add";
    }

    @RequestMapping(value = "/students/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") @Valid PersonDTO personDTO,
                              BindingResult bindingResult, Model model,
                              @RequestParam(required = false) Integer teacher_id,
                              @RequestParam(required = false) Integer group_id,
                              @RequestParam(required = false) Integer personId) throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null) {
            bindingResult.rejectValue("login", "1", "Login already exist.");
        }

        if (!bindingResult.hasErrors()) {

//          Read Existing student or get new Student()
            Student student = studentService.getStudentByPersonId(personId);

            if (teacher_id != null && teacher_id > 0) {
                Teacher teacher = teacherService.getById(teacher_id);
                student.setTeacher(teacher);
            }
            if (group_id != null && group_id > 0) {
                Group group = groupService.getById(group_id);
                student.setGroup(group);
            }

            student = studentService.updateRegisteredUser(student, personDTO);

            studentService.update(student);

            studentService.updatePosition(student, personDTO);

            return "redirect:/students";
        } else {
            model.addAttribute("groups", groupService.getAll());
            model.addAttribute("teachers", teacherService.getAll());
            model.addAttribute("cards", cardService.getCards(Pipe.STUDENT_PIPE));
            return "students/add";
        }
    }

    @RequestMapping(value = "/students/SortByDate", method = RequestMethod.POST)
    public String filterStudents(Model model) throws SQLException {

        List<Student> students = studentService.getSortedByRegistrationDate();
        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();

        model.addAttribute("students", students).addAttribute("teachers", teachers)
                .addAttribute("groups", groups);
        return "students/all";
    }

    @RequestMapping(value = "/students/delete")
    public String studentDelete(@RequestParam Integer id) throws SQLException {
        Student student = studentService.getById(id);
        studentService.delete(student);
        return "students/all";
    }

    @RequestMapping(value = "/students/trash")
    public String studentTrash(@RequestParam Integer id) throws SQLException {
        Student student = studentService.getById(id);
        studentService.trash(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/SortByTeacher", method = RequestMethod.POST)
    public String showSortedByTeacher(@RequestParam(required = false) Integer teacher_id, Model model) throws SQLException {

        List<Teacher> teachers = teacherService.getAll();
        List<Group> groups = groupService.getAll();
        List<Student> students = studentService.getAllByTeacher(teacher_id);

        model.addAttribute("students", students)
             .addAttribute("teachers", teachers)
             .addAttribute("groups", groups);
        return "students/all";
    }

    @RequestMapping(value = "/students/tests")
    public String studentTests(Model model) throws SQLException {
        model.addAttribute("levels", studentLevelHistoryService.getAll());

        return "students/tests";
    }

    @RequestMapping(value = "/students/{studentId}/add-testing-result")
    public String studentEditLevel(@PathVariable(value = "studentId") Integer id, Model model) throws SQLException {

        Student student = studentService.getById(id);

        model.addAttribute("student", student)
             .addAttribute("person", student.getPerson())
             .addAttribute("checkpointDate", new Date());

        return "students/testingResults";
    }

    @RequestMapping(value = "/students/{studentId}/save-testing-result", method = RequestMethod.POST)
    public String saveTestingResults(@ModelAttribute("studentLevelHistory") StudentLevelHistory studentLevelHistory,
                                     @PathVariable(value = "studentId") Integer studentId)
            throws SQLException, ParseException {

        Student student = studentService.getById(studentId);
        studentLevelHistory.setStudent(student);
        studentLevelHistory.setCheckpointDate(getDateFromString(studentLevelHistory.getTestingDate()));
        studentLevelHistoryService.insert(studentLevelHistory);
        return "redirect:/students";
    }

    public Date getDateFromString(String dateFromForm) throws ParseException {
        if (dateFromForm.equals("")){
            dateFromForm = "2001-01-01";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateFromForm);
        return date;
    }

    @RequestMapping(value = "/students/SortedByGroup", method = RequestMethod.POST)
    public String showSortedStudent(Model model, @RequestParam(required = false) List<Integer> groupIdList)
            throws SQLException {
        List<Group> groups = groupService.getAll();
        List<Teacher> teachers = teacherService.getAll();
        List<Student> students = new ArrayList<>();
        if (groupIdList != null && groupIdList.size() > 0) {
            if (groupIdList.contains(-1)) students.addAll(studentService.getStudentsWithoutGroup());
            if (groupIdList.contains(0)) students.addAll(studentService.getAllStudentsWithGroup());
            else {
                for (Integer id : groupIdList)
                    if (id > 0)
                        students.addAll(studentService.getAllByGroup(id));
            }
        } else {
            students = studentService.getAll();
        }
        model.addAttribute("groups", groups)
                .addAttribute("students", students)
                .addAttribute("teachers", teachers);
        return "students/all";

    }

    @RequestMapping(value = "/students/info", method = RequestMethod.GET)
    public String studentInfo(Model model, @RequestParam(value = "personId") Integer personId) throws SQLException {
        Student student = studentService.getStudentByPersonId(personId);
        Card currentCard = cardService.getCardByPerson(student.getPerson());
        List<Card> personCardList = cardService.getCards(Pipe.STUDENT_PIPE);
        List<Group> groups = groupService.getAll();

        model.addAttribute("groups", groups);
        model.addAttribute("currentCard", currentCard);
        model.addAttribute("personCardList", personCardList);
        model.addAttribute("student", student);
        model.addAttribute("level", studentLevelHistoryService.getLastByStudent(student));
        return "persons/student-info";
    }

    @RequestMapping(value = "/students/UpdateComments", method = RequestMethod.POST)
    public String studentUpdate(Model model,
                                @RequestParam Integer id,
                                @RequestParam String comments) throws SQLException {
        Student student = studentService.getById(id);
        student.getPerson().setComments(comments);
        studentService.update(student);
        model.addAttribute("student", student);
        return "persons/student-info";
    }

    @RequestMapping(value = "/studentUpdateGroup", method = RequestMethod.POST)
    public String studentUpdateGroup(Model model,
                                     @RequestParam Integer id,
                                     @RequestParam(required = false) Integer group_id) throws SQLException {

        Student student = studentService.getById(id);

        List<Group> groups = groupService.getAll();

        if (group_id != null && group_id > 0) {
            Group group = groupService.getById(group_id);
            student.setGroup(group);
        }
        studentService.update(student);

        model.addAttribute("student", student);
        model.addAttribute("groups", groups);

        return "persons/student-info";
    }


}