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

import javax.servlet.http.HttpServletRequest;
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
                                @RequestParam(required = false) Integer personId,
                                HttpServletRequest req
    ) throws SQLException {

        PersonDTO lead = new PersonDTO();
        req.getSession().setAttribute("callback", req.getHeader("Referer"));
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));
        model.addAttribute("personId", personId);
        if(personId != null){
            Person person = personService.getById(personId);
            lead.setFirstName(person.getFirstName());
            lead.setMiddleName(person.getMiddleName());
            lead.setLastName(person.getLastName());
            lead.setAvatarURL(person.getAvatarURL());
            lead.setEmail(person.getEmail().getEmail());
            Card card=cardService.getCardByPerson(person);
            cardId=card.getId();
            lead.setCardId(cardId);
        }else {
            if (cardId==null)cardId=1;
            lead.setCardId(cardId);
        }
        model.addAttribute("lead", lead);

        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLeadOnPipe(Model model, @ModelAttribute("lead") @Validated PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 HttpServletRequest req,
                                 @RequestParam(required = false) Integer personId)
            throws SQLException, ParseException {

        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        validator.validate(personDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("personId",personId);
            return "leads/add";
        }

        if (personId==null){
            Lead lead = new Lead();
            lead = personDTOService.updateLead(lead, personDTO);
            leadService.insert(lead);

            Card card = cardService.getById(personDTO.getCardId());
            card.getPersons().add(personService.getById(lead.getPerson().getId()));
            cardService.update(card);
        }else {
            Person person = personService.getById(personId);
            Lead lead = leadService.getByPerson(person);
            lead = personDTOService.updateLead(lead, personDTO);
            leadService.update(lead);
            Card cardOld = cardService.getCardByPerson(person);
            if (!personDTO.getCardId().equals(cardOld.getId())){
                cardOld.getPersons().remove(person);
                cardService.update(cardOld);
                Card cardNew = cardService.getById(personDTO.getCardId());
                cardNew.getPersons().add(person);
                cardService.update(cardNew);
            }
        }
        return "redirect:"+req.getSession().getAttribute("callback").toString();
    }

    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
    public String deleteLead(Model model,
                             @RequestParam(required = true)Integer personId,
                             HttpServletRequest req) throws SQLException{
        model.addAttribute("card", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        leadService.delete(lead);

        return "redirect:"+req.getHeader("Referer");
    }

    @RequestMapping(value = "/deleteLeadFromPipe", method = RequestMethod.POST)
    public String deleteLeadFromPipe(Model model,
                             @RequestParam(required = true) Integer personId,
                                     HttpServletRequest req)
            throws SQLException {

        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Card cards = cardService.getCardByPerson(person);
        cards.getPersons().remove(person);
        cardService.update(cards);
        Card card1 = cardService.getById(1);
        card1.getPersons().add(person);
        cardService.update(card1);


        return "redirect:"+req.getHeader("Referer");
    }

    @RequestMapping(value = "/leadTrash", method = RequestMethod.POST)
    public String leadTrash(Model model, @RequestParam(required = true) Integer personId,
                            HttpServletRequest req) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person persons = personService.getById(personId);
        Lead leads = leadService.getByPerson(persons);
        Card cards = cardService.getCardByPerson(persons);
        cards.getPersons().remove(persons);
        cardService.update(cards);
        leadService.trash(leads);

        return "redirect:"+req.getHeader("Referer");
    }
}