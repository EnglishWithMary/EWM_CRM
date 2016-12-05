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

    @Autowired
    PersonDTOService personDTOService;

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
    public String addLeadOnPipe(Model model,
                                @RequestParam(required = true) Integer cardId,
                                @RequestParam(required = true) Integer pipeTypeId
    ) throws SQLException {

        PersonDTO lead = new PersonDTO();
        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("lead", lead);
        model.addAttribute("pt_id", pipeTypeId);
        model.addAttribute("card_id", cardId);
        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLeadOnPipe(Model model, @ModelAttribute("lead") @Validated PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(required = true) Integer cardId,
                                 @RequestParam(required = true) Integer pipeTypeId)
            throws SQLException {

        model.addAttribute("cards", cardService.getCards(Pipe.valueOf(pipeTypeId)));
        model.addAttribute("pt", pipeTypeService.getPipe(Pipe.valueOf(pipeTypeId)));
        validator.validate(personDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("card_id", cardId);
            model.addAttribute("pt_id", pipeTypeId);
            return "leads/add";
        }

        Lead newLead = personDTOService.buildPerson(personDTO).getLead();
        leadService.insert(newLead);

        Card card = cardService.getById(personDTO.getCardId());
        card.getPersons().add(personService.getById(newLead.getPerson().getId()));
        cardService.update(card);
        return "redirect:/takeLeadtpipe";
    }

    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
    public String deleteLead(Model model,
                             @RequestParam(required = false) Integer cardId,
                             @RequestParam(required = false) Integer pipeTypeId,
                             @RequestParam(required = true) Integer id)
            throws SQLException {
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
}