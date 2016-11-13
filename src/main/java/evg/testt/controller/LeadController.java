package evg.testt.controller;

import evg.testt.dto.LeadDto;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.PersonEmails;
import evg.testt.model.Phone;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.LeadService;
import evg.testt.service.PersonEmailsService;
import evg.testt.service.PersonService;
import evg.testt.service.PhoneService;
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
    PersonEmailsService personEmailsService;

    @Autowired
    PhoneService phoneService;

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

        //TODO:add Builder to models
        Person newPerson = new Person();
        newPerson.setFirstName(leadDto.getFirstName());
        newPerson.setLastName(leadDto.getLastName());
        newPerson.setMiddleName(leadDto.getMiddleName());



        Set<Phone> phoneSet = new TreeSet<Phone>(new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {

                return 1;
            }
        });
        Phone phone= new Phone();
        phone.setPhone(leadDto.getPhone());
        phone.setPerson(newPerson);
        phoneSet.add(phone);
        newPerson.setPhones(phoneSet);

        Set<PersonEmails> personEmailsSet = new TreeSet<PersonEmails>(new Comparator<PersonEmails>() {
            @Override
            public int compare(PersonEmails o1, PersonEmails o2) {
                return 1;
            }
        });
        PersonEmails personEmails = new PersonEmails();
        personEmails.setEmail(leadDto.getEmail());
        personEmails.setPerson(newPerson);
        personEmailsSet.add(personEmails);
        newPerson.setEmails(personEmailsSet);

        Lead newLead = new Lead();
        newLead.setPerson(newPerson);
        try {
            personService.insert(newPerson);
            phoneService.insert(phone);
            personEmailsService.insert(personEmails);
            leadService.insert(newLead);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return showLeads();
    }


//    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
//    public ModelAndView saveLead(@ModelAttribute("lead") @Validated LeadDto leadDto,
//                                    BindingResult bindingResult) {
//
//
//        validator.validate(leadDto, bindingResult);
//        if (!bindingResult.hasErrors()) {
//
//        //TODO:add Builder to models
//        Person newPerson = new Person();
//        newPerson.setFirstName(leadDto.getFirstName());
//        newPerson.setLastName(leadDto.getLastName());
//        newPerson.setMiddleName(leadDto.getMiddleName());
//
//        Set<Phone> phoneSet= new HashSet<>();
//        Phone phone= new Phone();
//        phone.setPhone(leadDto.getPhone());
//        phone.setPerson(newPerson);
//        phoneSet.add(phone);
//        newPerson.setPhones(phoneSet);
//
//        Set<PersonEmails> personEmailsSet = new HashSet<>();
//        PersonEmails personEmails = new PersonEmails();
//        personEmails.setEmail(leadDto.getEmail());
//        personEmails.setPerson(newPerson);
//        personEmailsSet.add(personEmails);
//        newPerson.setEmails(personEmailsSet);
//
//        Lead newLead = new Lead();
//        newLead.setPerson(newPerson);
//
//        try {
//            personService.insert(newPerson);
//            phoneService.insert(phone);
//            personEmailsService.insert(personEmails);
//            leadService.insert(newLead);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//             return  showLeads();
//        }else{
//            return new ModelAndView(JspPath.LEAD_ADD);
//        }
//    }
}