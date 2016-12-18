package evg.testt.controller;

import antlr.Grammar;
import com.amazonaws.services.simpleworkflow.flow.core.TryCatch;
import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import evg.testt.service.impl.BaseService;
import evg.testt.service.impl.PersonDTOServiceImpl;
import evg.testt.service.impl.StudentLevelHistoryServiceImpl;
import evg.testt.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
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
    private TeacherService teacherService;
    @Autowired
    private PersonDTOService personDTOService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentLevelHistoryService studentLevelHistoryService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudent(@RequestParam(required = false) Integer teacher_id,
                              Model model) throws SQLException {

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
        .addAttribute("groups",groups);
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

        model.addAttribute("students", students).addAttribute("teachers",teachers)
                .addAttribute("groups",groups);
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
                                     @RequestParam Integer student_id,
                                     @RequestParam String testingDate)
            throws SQLException, ParseException {

        Student student = studentService.getById(student_id);

        StudentLevelHistory studentLevel = new StudentLevelHistory();
        studentLevel.setStudent(student);
        studentLevel.setCheckpointDate(getDateFromString(testingDate));
        studentLevel.setTestType(studentLevelHistory.getTestType());

        studentLevel.setGrammar(studentLevelHistory.getGrammar());
        studentLevel.setSpeaking(studentLevelHistory.getSpeaking());
        studentLevel.setFluency(studentLevelHistory.getFluency());
        studentLevel.setListening(studentLevelHistory.getListening());
        studentLevel.setPronunciation(studentLevelHistory.getPronunciation());
        studentLevel.setSpelling(studentLevelHistory.getSpelling());
        studentLevel.setReading(studentLevelHistory.getReading());
        studentLevel.setVocabulary(studentLevelHistory.getVocabulary());
        studentLevel.setWriting(studentLevelHistory.getWriting());

        studentLevelHistoryService.insert(studentLevel);
        return "students/all";
    }

    public Date getDateFromString(String dateFromForm) throws ParseException {
        if (dateFromForm == "") dateFromForm = "2001-01-01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(dateFromForm);
        return date;
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
}