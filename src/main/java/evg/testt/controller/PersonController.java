package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.BadAvatarNameException;
import evg.testt.exception.PersonException;
import evg.testt.exception.PersonRoleNotFoundException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    SpringOvalValidator validator;
    @Autowired
    PersonService personService;
    @Autowired
    AvatarService avatarService;

    @RequestMapping(value = "/personProfile", method = RequestMethod.GET)
    public ModelAndView profilePerson(@ModelAttribute("person") @Validated PersonDTO personDTO,
                                      BindingResult bindingResult,
                                      Principal principal) throws PersonRoleNotFoundException, SQLException{

        validator.validate(personDTO, bindingResult);

        Person person = personService.getPersonByUserLogin(principal.getName());

        return new ModelAndView(JspPath.PROFILE,"person", person);
    }

    @RequestMapping(value = "/personUpdate", method = RequestMethod.POST)
    public ModelAndView updatePerson(@ModelAttribute("person") @Validated PersonDTO personDTO,
                                     BindingResult bindingResult,
                                     @RequestParam("image") MultipartFile multipartFile,
                                     Principal principal)
            throws IOException, PersonException, PersonRoleNotFoundException, BadAvatarNameException {

        //Person validate
        validator.validate(personDTO, bindingResult);
        //Create updated person
        String login = principal.getName();
        try {
            Person person = personService.getPersonByUserLogin(login);

            person.setFirstName(personDTO.getFirstName());
            person.setMiddleName(personDTO.getMiddleName());
            person.setLastName(personDTO.getLastName());

            //Update person in DB
            personService.update(person);

            //Update Avatar if exist
            if (!multipartFile.isEmpty()) {

                avatarService.changePersonAvatar(multipartFile, person);

            }
        } catch (SQLException e) {
            throw new PersonException("Can't update Person Profile with login" + login);
        }

        return new ModelAndView(JspPath.HOME);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView showGroups() {
        List<Person> persons = Collections.EMPTY_LIST;
        try {
            persons=personService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.PERSON_ALL, "persons", persons);
        return modelAndView;
    }

    @RequestMapping(value = "/personSortByDate", method = RequestMethod.POST)
    public ModelAndView filterPersons() {
        List<Person> persons = Collections.EMPTY_LIST;
        try {
            persons = personService.getSortedByRegistrationDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.PERSON_ALL, "persons", persons);
        return modelAndView;
    }

}


