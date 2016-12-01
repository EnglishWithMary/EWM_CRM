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
import java.util.Collections;
import java.util.List;

@Controller
public class PipelineController {

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

    @RequestMapping(value = "/pipeline", method = RequestMethod.GET)
    public String goToPipelinepage(Model model) {
        PipeType pt = new PipeType();
        model.addAttribute("pt", pt);

        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(Model model, Principal principal, @RequestParam(required = true) int pt_id)throws SQLException {
        Card card = new Card();
        Pipe pipe = Pipe.valueOf(pt_id);
        PipeType pt;
        try {
            pt = pipeTypeService.getPipe(pipe);
            card.setType(pt);
            cardService.insert(card);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        inserAttributes(model, principal, pipe);
        return "pipeline/pipeline";
    }


    @RequestMapping(value = "/takeStudentpipe", method = RequestMethod.GET)
    public String takeStudent(Model model, Principal principal) {
        inserAttributes(model, principal, Pipe.STUDENT_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/takeLeadtpipe", method = RequestMethod.GET)
    public String takeLead(Model model, Principal principal) {
        inserAttributes(model, principal, Pipe.LEAD_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public String deleteCard(Model model, Principal principal, int card_id, int pt_id) {
        Pipe pipe = Pipe.valueOf(pt_id);
        Card card = new Card();

        try {
            card = cardService.getById(card_id);
            cardService.delete(card);
        } catch (Exception e) {
            e.printStackTrace();
        }

        inserAttributes(model, principal, pipe);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/editCardName", method = RequestMethod.POST)
    public String editCardName(Model model, String cardName, int card_id, int pt_id, Principal principal) {
        Card card = null;
        Pipe pipe = Pipe.valueOf(pt_id);

        try {
            card = cardService.getById(card_id);
            card.setCardName(cardName);
            cardService.update(card);
        } catch (Exception e) {
            e.printStackTrace();
        }

        inserAttributes(model, principal, pipe);

        return "redirect:pipeline/pipeline";
    }

    private void inserAttributes(Model model, Principal principal, Pipe pipe) {
        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            cards = cardService.getCards(pipe);
            pt = pipeTypeService.getPipe(pipe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
    }
}