package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.BadAvatarNameException;
import evg.testt.exception.PersonException;
import evg.testt.model.Person;
import evg.testt.model.Personnel;
import evg.testt.model.SearchedPerson;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

//import evg.testt.exception.PersonRoleNotFoundException;
//import evg.testt.oval.SpringOvalValidator;

@Controller
public class PersonController {

//    @Autowired
//    private SpringOvalValidator validator;
    @Autowired
    private SearchService searchService;
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

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profilePerson(@ModelAttribute("person") @Valid PersonDTO personDTO,
                                BindingResult bindingResult,
                                Principal principal, Model model)
            throws SQLException {

        Person person = personService.getPersonByUserLogin(principal.getName());
        model.addAttribute("person", person);
        return "profile";
    }

//    /persons/updatePerson
//    old name /personUpdate
    @RequestMapping(value = "/persons/updatePerson", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") @Valid PersonDTO personDTO,
                               BindingResult bindingResult,
                               @RequestParam("image") MultipartFile multipartFile,
                               Principal principal)
            throws
            IOException, PersonException, BadAvatarNameException,
            SQLException, ParseException {

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
        return "redirect:/profile";
    }

//   what to rename here?
    @RequestMapping(value = "/personSortByDate", method = RequestMethod.POST)
    public String filterPersons(Model model) throws SQLException {
        List<Person> persons = personService.getSortedByRegistrationDate();
        model.addAttribute("persons", persons);
        return "persons/all";
    }

    //   what to rename here?
    @RequestMapping(value = "/personDelete")
    public String personDelete(@RequestParam Integer id) throws SQLException {
        Person person = personService.getById(id);
        personService.delete(person);
        return "persons/all";
    }

    @RequestMapping(value = "/fullSearch")
    public String search(Model model, @RequestParam String searchText) throws SQLException {

        List<SearchedPerson> persons = Collections.EMPTY_LIST;
        if(!searchText.equals(""))
        persons = searchService.getPersonsByKeyWord(searchText);

        model.addAttribute("persons", persons);
        return "search/all";
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