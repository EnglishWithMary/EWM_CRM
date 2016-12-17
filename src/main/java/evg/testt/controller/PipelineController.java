package evg.testt.controller;

import evg.testt.ajax.utils.AjaxFormCall;
import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.SQLException;

@Controller
public class PipelineController {

    @Autowired
    private PipeTypeService pipeTypeService;
    @Autowired
    private CardService cardService;
//    @Autowired
//    private SpringOvalValidator validator;
    @Autowired
    private LeadService leadService;
    @Autowired
    private PersonService personService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/pipeline", method = RequestMethod.GET)
    public String goToPipelinepage(Model model) {
        PipeType pt = new PipeType();
        model.addAttribute("pipeType", pt);

        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(Model model, @RequestParam int pipeTypeId)
            throws SQLException {
        Card card = new Card();
        Pipe pipe = Pipe.valueOf(pipeTypeId);
        PipeType pt = pipeTypeService.getPipe(pipe);
        card.setType(pt);
        cardService.insert(card);
        this.inserAttributes(model, pipe);
        if (pipe==Pipe.LEAD_PIPE){
            return "redirect:/takeLeadtpipe";
        }else if (pipe==Pipe.STUDENT_PIPE){
            return "redirect:/takeStudentpipe";
        }else{
            return "redirect:/pipeline";
        }

    }

    @RequestMapping(value = "/takeStudentpipe", method = RequestMethod.GET)
    public String takeStudent(Model model)throws SQLException{
        this.inserAttributes(model, Pipe.STUDENT_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/takeLeadtpipe", method = RequestMethod.GET)
    public String takeLead(Model model) throws SQLException {
        this.inserAttributes(model, Pipe.LEAD_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public String deleteCard(Model model,
                             @RequestParam Integer cardId,
                             @RequestParam Integer pipeTypeId)
            throws SQLException {
        Pipe pipe = Pipe.valueOf(pipeTypeId);
        Card card = cardService.getById(cardId);
        card.getPersons().clear();
        cardService.update(card);
        cardService.delete(card);
        this.inserAttributes(model, pipe);
        return "redirect:/takeLeadtpipe";
    }

    @RequestMapping(value = "/editCardName", method = RequestMethod.POST)
    public String editCardName(Model model, String cardName,
                               @RequestParam Integer cardId,
                               @RequestParam Integer pipeTypeId) throws SQLException {
        Card card = cardService.getById(cardId);
        Pipe pipe = Pipe.valueOf(pipeTypeId);
        card.setCardName(cardName);
        cardService.update(card);
        this.inserAttributes(model, pipe);
        return "redirect:/takeLeadtpipe";
    }

    @ResponseBody
    @RequestMapping(value = "/moveLeadAjax", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void moveLeadAjax(@RequestBody AjaxFormCall ajaxFormCall) throws SQLException {
        if(ajaxFormCall.getDestination() != ajaxFormCall.getFrom())
        {
            cardService.movePersonOnCards(ajaxFormCall.getFrom(), ajaxFormCall.getDestination(), ajaxFormCall.getPersonId());
        }
    }

    private void inserAttributes(Model model, Pipe pipe)
            throws SQLException {
        model.addAttribute("cards", cardService.getCards(pipe));
        model.addAttribute("pipeType", pipeTypeService.getPipe(pipe));
    }
}