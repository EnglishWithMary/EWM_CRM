package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.BadAvatarNameException;
import evg.testt.exception.PersonException;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.*;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String profilePerson(@ModelAttribute("person") @Validated PersonDTO personDTO,
                                      BindingResult bindingResult,
                                      Principal principal, Model model) throws PersonRoleNotFoundException, SQLException{

        validator.validate(personDTO, bindingResult);

        Person person = personService.getPersonByUserLogin(principal.getName());

        model.addAttribute("person", person);
        return "profile";
    }

    @RequestMapping(value = "/personUpdate", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") @Validated PersonDTO personDTO, BindingResult bindingResult,
                                     @RequestParam("image") MultipartFile multipartFile, Principal principal,
                               Model model)
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

        return "redirect:/home";
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String showGroups(Model model) throws SQLException {
        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);
        return "persons/all";
    }

    @RequestMapping(value = "/personSortByDate", method = RequestMethod.POST)
    public String filterPersons(Model model) throws SQLException {
        List<Person> persons = personService.getSortedByRegistrationDate();
        model.addAttribute("persons", persons);
        return "persons/all";
    }

}

