package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Manager;
import evg.testt.model.Teacher;
import evg.testt.model.User;
import evg.testt.service.ManagerService;
import evg.testt.service.PersonDTOService;
import evg.testt.service.TeacherService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;

@Controller
public class PersonnelController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/managersWithPersonnelAdd")
    public String addManagerPersonnel(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("managerWithPersonnel", person);
        return "personnels/addManager";
    }

    @RequestMapping(value = "/managersSaveWithPersonnel", method = RequestMethod.POST)
    public String saveManagerPersonnel(@ModelAttribute("managerWithPersonnel") @Valid PersonDTO personDTO,
                              BindingResult bindingResult, Model model) throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {
            Manager manager = new Manager();
            manager = personDTOService.updateRegisteredUser(manager, personDTO);
            managerService.insert(manager);

            return "redirect:/persons";
        } else {
            return "personnels/addManager";
        }
    }

    @RequestMapping(value = "/teachersWithPersonnelAdd")
    public String addTeacher(Model model) {
        PersonDTO person =  new PersonDTO();
        model.addAttribute("teacherWithPersonnelAdd", person);
        return "personnels/addTeacher";
    }

    @RequestMapping(value = "/teachersSaveWithPersonnel", method = RequestMethod.POST)
    public String saveTeacher(@Valid @ModelAttribute("teacherWithPersonnelAdd")  PersonDTO personDTO,
                              BindingResult bindingResult,
                              Model model) throws SQLException, ParseException {

        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Teacher teacher = new Teacher();
            teacher = personDTOService.updateRegisteredUser(teacher, personDTO);
            teacherService.insert(teacher);

            return "redirect:/persons";
        } else {
            return "personnel/addTeacher";
        }
    }

}
