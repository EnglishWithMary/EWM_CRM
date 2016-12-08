package evg.testt.controller;

import evg.testt.dto.PersonDTO;
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

import java.security.Principal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Controller
public class LeadController {

    @Autowired
    private PipeTypeService pipeTypeService;
    @Autowired
    private CardService cardService;
    @Autowired
    private SpringOvalValidator validator;
    @Autowired
    private LeadService leadService;
    @Autowired
    private PersonService personService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PersonDTOService personDTOService;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String showLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getAll();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leadSortByDate", method = RequestMethod.POST)
    public String filterLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getSortedByRegistrationDate();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leadAdd", method = RequestMethod.POST)
    public String addLeadOnPipe(Model model,
                                @RequestParam(required = false) Integer cardId,
                                @RequestParam(required = false) Integer pipeTypeId,
                                @RequestParam(required = false) Integer personId
    ) throws SQLException {

        PersonDTO lead = new PersonDTO();

        if (personId != null) {
            Person person = personService.getById(personId);
            lead.setFirstName(person.getFirstName());
            lead.setMiddleName(person.getMiddleName());
            lead.setLastName(person.getLastName());
            lead.setAvatarURL(person.getAvatarURL());
            lead.setEmail(person.getEmail().getEmail());
            if (cardId==null) {
                Card card=cardService.getCardByPerson(person);
                if (card!=null)cardId=card.getId();
            }
            lead.setCardId(cardId);
        }
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));//.valueOf(pipeTypeId)));
        if (pipeTypeId!=null) model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("lead", lead);
        model.addAttribute("card_id", cardId);
        model.addAttribute("personId", personId);
        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLeadOnPipe(Model model, @ModelAttribute("lead") @Validated PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(required = true) Integer card_id,
                                 @RequestParam(required = true) Integer pipeTypeId,
                                 @RequestParam(required = false) Integer personId
    ) throws SQLException, ParseException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        if (pipeTypeId!=null) {
            model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        }
        validator.validate(personDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("card_id", card_id);
            model.addAttribute("personId",personId);
            return "leads/add";
        }
        Person person;
        if (personId==null) {
            Lead newLead = personDTOService.buildPerson(personDTO).getLead();
            leadService.insert(newLead);
            Card card = cardService.getById(personDTO.getCardId());
            card.getPersons().add(personService.getById(newLead.getPerson().getId()));
            cardService.update(card);
        }else{
            person=personService.getById(personId);
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setMiddleName(personDTO.getMiddleName());
            Email email = person.getEmail();
            email.setEmail(personDTO.getEmail());
            emailService.update(email);
            Lead lead = leadService.getByPerson(person);
            lead.setPerson(person);
            leadService.update(lead);
            if (personDTO.getCardId()!= card_id ) {
                if (card_id!=null){
                    Card cardOld = cardService.getById(card_id);
                    //cardOld.getPersons().remove(person);
                    for (Person p:cardOld.getPersons()) {
                        if (p.getId().equals(person.getId())){
                            cardOld.getPersons().remove(p);
                            break;
                        }
                    }
                    cardService.update(cardOld);
                }
                Card cardNew = cardService.getById(personDTO.getCardId());
                cardNew.getPersons().add(person);
                cardService.update(cardNew);
            }
        }
        if (pipeTypeId!=null)
            return "redirect:/takeLeadtpipe";
        else
            return "redirect:/leads";
    }

    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
    public String deleteLead(Model model,
                             @RequestParam(required = false) Integer pipeTypeId,
                             @RequestParam(required = true) Integer personId) throws SQLException {
        if (pipeTypeId!=null){
            model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
            model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        }
        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        //card.getPersons().remove(person);
        for (Person p:card.getPersons()) {
            if (p.getId().equals(person.getId())){
                card.getPersons().remove(p);
                break;
            }
        }
        cardService.update(card);
        leadService.delete(lead);
        if (pipeTypeId!=null)
            return "redirect:/takeLeadtpipe";
        else
            return "redirect:/leads";
    }

    @RequestMapping(value = "/leadTrash", method = RequestMethod.POST)
    public String leadTrash(Model model, @RequestParam(required = false) Integer pipeTypeId,
                            @RequestParam(required = true) Integer personId) throws SQLException {
        if (pipeTypeId!=null){
            model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
            model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        }
        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        //card.getPersons().remove(person);
        for (Person p:card.getPersons()) {
            if (p.getId().equals(person.getId())){
                card.getPersons().remove(p);
                break;
            }
        }
        cardService.update(card);
        leadService.trash(lead);
        if (pipeTypeId!=null)
            return "redirect:/takeLeadtpipe";
        else
            return "redirect:/leads";
    }
    @RequestMapping(value = "/leadDeleteFromPipe", method = RequestMethod.POST)
    public String leadDeleteFromPipe(Model model, @RequestParam(required = false) Integer pipeTypeId,
                            @RequestParam(required = true) Integer personId) throws SQLException {
        if (pipeTypeId!=null){
            model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
            model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        }
        Person person = personService.getById(personId);
        Card card = cardService.getCardByPerson(person);
        //card.getPersons().remove(person);
        for (Person p:card.getPersons()) {
            if (p.getId().equals(person.getId())){
                card.getPersons().remove(p);
                break;
            }
        }
        cardService.update(card);
        Card cardNew=cardService.getById(1);
        cardNew.getPersons().add(person);
        cardService.update(cardNew);
        if (pipeTypeId!=null)
            return "redirect:/takeLeadtpipe";
        else
            return "redirect:/leads";
    }
}
