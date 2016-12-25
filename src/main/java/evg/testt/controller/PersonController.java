package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.BadAvatarNameException;
import evg.testt.exception.PersonException;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;
import evg.testt.model.Personnel;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.AvatarService;
import evg.testt.service.PersonDTOService;
import evg.testt.service.PersonService;
import evg.testt.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Controller
public class PersonController {

    @Autowired (required = false)
    private SpringOvalValidator validator;
    @Autowired
    private PersonService personService;
    @Autowired
    private AvatarService avatarService;
    @Autowired
    private PersonDTOService personDTOService;
    @Autowired
    private PersonnelService personnelService;
    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/personProfile", method = RequestMethod.GET)
    public String profilePerson(@ModelAttribute("person") @Validated PersonDTO personDTO,
                                BindingResult bindingResult,
                                Principal principal, Model model)
            throws PersonRoleNotFoundException, SQLException {

        validator.validate(personDTO, bindingResult);

        Person person = personService.getPersonByUserLogin(principal.getName());

        model.addAttribute("person", person);
        return "profile";
    }

    @RequestMapping(value = "/personUpdate", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") @Validated PersonDTO personDTO,
                               BindingResult bindingResult,
                               @RequestParam("image") MultipartFile multipartFile,
                               Principal principal,
                               Model model)
            throws
            IOException, PersonException, PersonRoleNotFoundException,
            BadAvatarNameException, SQLException, ParseException {

        validator.validate(personDTO, bindingResult);

//        if (bindingResult.hasErrors()) {
//            return "redirect:/personProfile";
//        }

        String login = principal.getName();

        try {

            Person person = personService.getPersonByUserLogin(login);

            person = personDTOService.getUpdatedPerson(person,personDTO);

            personService.update(person);

            if (!multipartFile.isEmpty()) {
                avatarService.changePersonAvatar(multipartFile, person);
            }
        } catch (SQLException e) {
            throw new PersonException("Can't update Person Profile with login" + login);
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String showGroups(Model model, @RequestParam(required = false) Integer page) throws SQLException {

        page = (page == null || page < 1) ? 1 : page;

        int count = personnelService.count();
        int pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

        List<Personnel> personnel = personnelService.getAllSortedAndPaginated(page);
        model.addAttribute("personnel", personnel);
        model.addAttribute("pages", pages);
        return "persons/all";
    }






//    @RequestMapping(value = "/persons", method = RequestMethod.GET)
//    public String showGroups(Model model, @RequestParam(required = false) Integer page) throws SQLException {
//
//        page = (page == null || page < 1) ? 1 : page;
//
//        int count = personnelService.count();
//        int pages = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
//
//        List<Personnel> personnel = personnelService.getAll();
//        model.addAttribute("personnel", personnel);
//        model.addAttribute("pages", pages);
//        return "personnel";
//    }



    @RequestMapping(value = "/personSortByDate", method = RequestMethod.POST)
    public String filterPersons(Model model) throws SQLException {
        List<Person> persons = personService.getSortedByRegistrationDate();
        model.addAttribute("persons", persons);
        return "persons/all";
    }

    @RequestMapping(value = "/personDelete")
    public String personDelete(@RequestParam Integer id) throws SQLException {
        Person person = personService.getById(id);
        personService.delete(person);
        return "persons/all";
    }

    /*
        Feature is added with one reason - to test if Student info is acceptable to work with
     */
    @RequestMapping(value = "/test/student-info")
    public String testStudentInfo(){
        return "persons/students/test/info";
    }

    @RequestMapping(value = "/test/teacher-info")
    public String testTeacherInfo(){
        return "persons/teachers/test/info";
    }

    @RequestMapping(value = "/test/manager-info")
    public String testManagerInfo(){
        return "persons/managers/test/info";
    }

    @RequestMapping(value = "/test/lead-info")
    public String testLeadInfo(){
        return "persons/leads/test/info";
    }

    @RequestMapping(value = "/test/group-info")
    public String testGroupInfo(){
        return "persons/groups/test/info";
    }
}