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
import java.util.List;

@Controller
public class LeadController {
    @Autowired
    private UserService userService;
    @Autowired
    private PipeTypeService pipeTypeService;
    @Autowired
    private CardService cardService;

    @Autowired
    SpringOvalValidator validator;

    @Autowired
    LeadService leadService;

    @Autowired
    PersonService personService;

    @Autowired
    EmailService emailService;


    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String showLeads(Model model, Principal principal) throws SQLException {
        List<Lead> leads = leadService.getAll();
        model.addAttribute("leads", leads);
//        insertAttributes(model, principal, Pipe.LEAD_PIPE);
        return "leads/all";
    }

    @RequestMapping(value = "/leadSortByDate", method = RequestMethod.POST)
    public String filterLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getSortedByRegistrationDate();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leadAdd", method = RequestMethod.POST)
    public String addLeadOnPipe(Model model, Principal principal,
                                @RequestParam(required = true) Integer cardId,
                                @RequestParam(required = true) Integer pipeTypeId
//                                @RequestParam(required = false) Integer cardId
                                ) throws SQLException {

        PersonDTO lead = new PersonDTO();
//        Pipe pipe = Pipe.valueOf(pipeTypeId);
//        insertAttributes(model, principal, pipe);

        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));

//        if (cardId != null) {
//            Card card = cardService.getById(cardId);
//            lead.setFirstName(cardPerson.getPerson().getFirstName());
//            lead.setMiddleName(cardPerson.getPerson().getMiddleName());
//            lead.setLastName(cardPerson.getPerson().getLastName());
//            lead.setEmail(cardPerson.getPerson().getEmail().getEmail());
//            lead.setCardId(cardId);
//        }

        model.addAttribute("lead", lead);
        model.addAttribute("pt_id", pipeTypeId);
//        model.addAttribute("cardPersonId", cardId);
        model.addAttribute("card_id", cardId);
        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLeadOnPipe(Model model, Principal principal,
                                 @ModelAttribute("lead") @Validated PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(required = true) Integer cardId,
                                 @RequestParam(required = true) Integer pipeTypeId,
                                 @RequestParam(required = false) Integer cardPersonId)
            throws SQLException {

//        Pipe pipe = Pipe.valueOf(pipeTypeId);
        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
//        insertAttributes(model, principal, pipe);

        validator.validate(personDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("card_id", cardId);
            model.addAttribute("pt_id", pipeTypeId);
            model.addAttribute("cardPersonId", cardPersonId);
            return "leads/add";
        }

        if (cardPersonId == null) {

            Person newPerson = new Person();

            newPerson.setFirstName(personDTO.getFirstName());
            newPerson.setLastName(personDTO.getLastName());
            newPerson.setMiddleName(personDTO.getMiddleName());

            Email newEmail = new Email();

            newEmail.setEmail(personDTO.getEmail());

            Lead newLead = new Lead();

//            CardPerson cardPerson = new CardPerson();

//            emailService.insert(newEmail);

            newPerson.setEmail(newEmail);
//            personService.insert(newPerson);

            newLead.setPerson(newPerson);

            leadService.insert(newLead);

            Card card = cardService.getById(personDTO.getCardId());

            card.getPersons().add(personService.getById(newPerson.getId()));
//            cardPerson.setCard(card);

            cardService.update(card);

//            card.getCardPersons().add(cardPerson);

//            cardService.update(card);

        } else {
//            CardPerson cardPerson = cardPersonService.getById(cardId);
//            Card newCard = cardService.getById(personDTO.getCardId());
//            Card oldCard = cardService.getById(cardId);
//
//            cardPerson.setCard(newCard);
//
//            cardPerson.getPerson().setFirstName(personDTO.getFirstName());
//            cardPerson.getPerson().setMiddleName(cardPerson.getPerson().getMiddleName());
//            cardPerson.getPerson().setLastName(cardPerson.getPerson().getLastName());
//            cardPerson.getPerson().getEmail().setEmail(personDTO.getEmail());
//
//            if(!newCard.getId().equals(oldCard.getId())){
//                newCard.getCardPersons().add(cardPerson);
//
//                cardService.update(newCard);
//                oldCard.getCardPersons().remove(cardPerson);
//
//                cardService.update(oldCard);
//
//            }else{
//                cardService.update(newCard);
//            }
//            cardPersonService.update(cardPerson);
        }

        if (cardId ==null) return showLeads(model, principal);
        return "pipeline/pipeline";
    }


    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
    public String deleteLeadFromPipe(Model model, Principal principal,
                                     @RequestParam(required = false) Integer cardPersonId,
                                     @RequestParam(required = true) Integer cardId,
                                     @RequestParam(required = true) Integer pipeTypeId,
                                     @RequestParam(required = false) Integer id)
            throws SQLException {

//        Pipe pipe = Pipe.valueOf(pipeTypeId);
        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
//        insertAttributes(model, principal, pipe);

        Lead lead=null;

        if (cardPersonId!=null) {
//            CardPerson cardPerson = cardPersonService.getById(cardId);
//            Person person = cardPerson.getPerson();
//            lead = leadService.getByPerson(person);
//            cardPersonService.delete(cardPerson);
//            personService.delete(person);
            leadService.delete(lead);
        }
        if(id!=null){
            lead= leadService.getById(id);
            leadService.delete(lead);
            return showLeads(model,principal);
        }
        return "pipeline/pipeline";
    }

//    private void insertAttributes(Model model, Principal principal, Pipe pipe) {
//        PipeType pt = new PipeType();
//        List<Card> cards = Collections.EMPTY_LIST;
//        try {
//            cards = cardService.getCards(principal, pipe);
//            pt = pipeTypeService.getPipe(pipe);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("cards", cards);
//        model.addAttribute("pt", pt);
//    }

}