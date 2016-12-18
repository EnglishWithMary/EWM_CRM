package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.LeadService;
import evg.testt.service.PersonService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.*;

@Controller
public class LeadController {

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    LeadService leadService;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public ModelAndView showLeads() {
        List<Lead> leads = Collections.EMPTY_LIST;
        try {
            leads = leadService.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView(JspPath.LEAD_ALL, "leads", leads);
    }
    @RequestMapping(value = "/leadDelete")
    public ModelAndView deleteLead(@RequestParam Integer id) {
        Lead lead= null;
        try {
            lead = leadService.getById(id);
            leadService.delete(lead);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showLeads();
    }
    @RequestMapping(value = "/leadAdd")
    public ModelAndView addLead(Model model) {
        PersonDTO lead = new PersonDTO();
        model.addAttribute("lead", lead);
        return new ModelAndView(JspPath.LEAD_ADD);
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public ModelAndView saveLead(@ModelAttribute("lead") @Validated PersonDTO personDTO,
                                 BindingResult bindingResult) {
        validator.validate(personDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView(JspPath.LEAD_ADD);
        }

        Person newPerson = new Person();
        newPerson.setFirstName(personDTO.getFirstName());
        newPerson.setLastName(personDTO.getLastName());
        newPerson.setMiddleName(personDTO.getMiddleName());
        Lead newLead = new Lead();
        try {
            personService.insert(newPerson);
            newLead.setPerson(newPerson);
            leadService.insert(newLead);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showLeads();
    }

    @RequestMapping(value = "/leadSortByDate", method = RequestMethod.POST)
    public ModelAndView filterLeads() {
        List<Lead> leads = Collections.EMPTY_LIST;
        try {
            leads=leadService.getSortedByRegistrationDate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView=new ModelAndView(JspPath.LEAD_ALL, "leads", leads);
        return modelAndView;
    }
}