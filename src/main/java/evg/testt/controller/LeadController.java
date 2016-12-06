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
    private EmailService emailService;
    @Autowired
    private PersonDTOService personDTOService;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String showLeads(Model model) throws SQLException {
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
    ) throws SQLException {

        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        if (pipeTypeId!=null) {
            model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
            model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        }


        validator.validate(personDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("card_id", card_id);
            //model.addAttribute("pt_id", pipeTypeId);
            model.addAttribute("personId",personId);
            return "leads/add";
        }

        Person person;
        if (personId==null) {
            /*person = new Person();
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setMiddleName(personDTO.getMiddleName());
            Email newEmail = new Email();
            newEmail.setEmail(personDTO.getEmail());
            Lead newLead = new Lead();
            person.setEmail(newEmail);
            newLead.setPerson(person);
            leadService.insert(newLead);
            Card card = cardService.getById(personDTO.getCardId());
            card.getPersons().add(personService.getById(person.getId()));
            cardService.update(card);*/
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
            //todo update email
            person.getEmail().setEmail(personDTO.getEmail());
            Lead lead = leadService.getByPerson(person);
            lead.setPerson(person);
            leadService.update(lead);
            if (personDTO.getCardId()!= card_id ) {
                if (card_id!=null){
                    Card cardOld = cardService.getById(card_id);
                    //cardOld.getPersons().remove(person);
                    //this line doesn't work so I have to write this crutch loop
                    //todo somehow fix this
                    int i=0;
                    for (Person p:cardOld.getPersons()) {
                        Boolean b=p.getId().equals(person.getId());
                        if (b){
                            cardOld.getPersons().remove(p);
                            break;
                        }
                        i++;
                    }
                    cardService.update(cardOld);
                }
                Card cardNew = cardService.getById(personDTO.getCardId());
                cardNew.getPersons().add(person);
                cardService.update(cardNew);
            }
        }
        if (pipeTypeId!=null) {
            return "redirect:/takeLeadtpipe";
        }
        else{
            return "redirect:/leads";
        }

    }

    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
    public String deleteLead(Model model,
                             @RequestParam(required = false) Integer cardId,
                             @RequestParam(required = false) Integer pipeTypeId,
                             @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        if (cardId != null) {
            Card card = cardService.getById(cardId);
            card.getPersons().remove(person);
            cardService.update(card);
        }
        State state = new State();
        /*state.setState(StateType.STATE_DELETED.toString());
        person.setState(state); TODO delete or remove to trash leads
        personService.update(person);
        personService.delete(person);*/
        //leadService.delete(lead);
        return "redirect:/takeLeadtpipe";
    }

    @RequestMapping(value = "/deleteLeadFromPipe", method = RequestMethod.POST)
    public String deleteLeadFromPipe(
                             @RequestParam(required = false) Integer cardId,
                             @RequestParam(required = false) Integer pipeTypeId,
                             @RequestParam(required = true) Integer id)
            throws SQLException {
        if (cardId != null) {
            Card card = cardService.getById(cardId);
            card.getPersons().remove(personService.getById(leadService.getById(id).getId()));
            cardService.update(card);
        }
        return "redirect:/takeLeadtpipe";
    }

    @RequestMapping(value = "/leadTrash", method = RequestMethod.POST)
    public String leadTrash(Model model, @RequestParam(required = true) Integer id) throws SQLException {
        Lead lead = leadService.getById(id);
        leadService.trash(lead);
        return "leads/all";
    }
}