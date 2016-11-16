package evg.testt.controller;

import evg.testt.dto.LeadDto;
import evg.testt.model.Email;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.EmailService;
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

    @Autowired
    EmailService emailService;

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
        LeadDto lead = new LeadDto();
        model.addAttribute("lead", lead);
        return new ModelAndView(JspPath.LEAD_ADD);
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public ModelAndView saveLead(@ModelAttribute("lead") @Validated LeadDto leadDto,
                                 BindingResult bindingResult) {
        validator.validate(leadDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView(JspPath.LEAD_ADD);
        }

        Email email=new Email();
        email.setEmail(leadDto.getEmail());
        try {
            emailService.insert(email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Person newPerson = new Person();
        newPerson.setFirstName(leadDto.getFirstName());
        newPerson.setLastName(leadDto.getLastName());
        newPerson.setMiddleName(leadDto.getMiddleName());
        newPerson.setEmail(email);
        try {
            personService.insert(newPerson);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Lead newLead = new Lead();
        newLead.setPerson(newPerson);
        try {
            leadService.insert(newLead);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showLeads();
    }
}