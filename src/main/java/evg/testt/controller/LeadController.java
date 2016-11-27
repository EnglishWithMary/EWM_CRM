package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.PersonState;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.LeadService;
import evg.testt.service.PersonService;
import evg.testt.service.StateService;
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
import java.util.List;

@Controller
public class LeadController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    LeadService leadService;

    @Autowired
    PersonService personService;

    @Autowired
    StateService stateService;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String showLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getAll();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leadDelete")
    public String deleteLead(@RequestParam Integer id) throws SQLException {
        Lead lead = leadService.getById(id);
        Person person = lead.getPerson();
        personService.delete(person);
        return "redirect:/leads";
    }

    @RequestMapping(value = "/leadAdd")
    public String addLead(Model model) {
        PersonDTO lead = new PersonDTO();
        model.addAttribute("lead", lead);
        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLead(@ModelAttribute("lead") @Validated PersonDTO personDTO,
                           BindingResult bindingResult, Model model) throws SQLException {
        validator.validate(personDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "leads/add";
        }

        Person newPerson = new Person();
        newPerson.setFirstName(personDTO.getFirstName());
        newPerson.setLastName(personDTO.getLastName());
        newPerson.setMiddleName(personDTO.getMiddleName());
        newPerson.setState(stateService.getById(PersonState.STATE_ACTIVE.getStateId()));

        Lead newLead = new Lead();
        personService.insert(newPerson);
        newLead.setPerson(newPerson);
        leadService.insert(newLead);
        return "redirect:/leads";
    }

    @RequestMapping(value = "/leadSortByDate", method = RequestMethod.POST)
    public String filterLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getSortedByRegistrationDate();
        model.addAttribute("leads", leads);
        return "leads/all";
    }
}