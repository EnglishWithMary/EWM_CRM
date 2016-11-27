package evg.testt.controller;

import evg.testt.model.*;
import evg.testt.service.CardService;
import evg.testt.service.PipeTypeService;
import evg.testt.service.UserService;
import evg.testt.util.JspPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Controller
public class PipelineController {

    @Autowired
    private UserService us;

    @Autowired
    private PipeTypeService pts;

    @Autowired
    private CardService cs;

    @RequestMapping(value = "/pipeline", method = RequestMethod.GET)
    public String goToPipelinepage(Model model)
    {
        PipeType pt = new PipeType();
        model.addAttribute("pt", pt);

        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(Model model, Principal principal,@RequestParam(required = true) int pt_id)
    {
        Card card = new Card();
        Pipe pipe = Pipe.valueOf(pt_id);

        User user = us.findByUserLogin(principal.getName());

        PipeType pt = new PipeType();

        try {
            pt = pts.getPipe(pipe);
            card.setUser(user);
            card.setType(pt);
            cs.insert(card);

        } catch (Exception e) {
            e.printStackTrace();
        }

        inserAttributes(model, principal, pipe);
        return "pipeline/pipeline";
    }


    @RequestMapping(value = "/takeStudentpipe", method = RequestMethod.GET)
    public String takeStudent(Model model, Principal principal)
    {
        inserAttributes(model, principal, Pipe.STUDENT_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/takeLeadtpipe", method = RequestMethod.GET)
    public String takeLead(Model model, Principal principal)
    {
        inserAttributes(model, principal, Pipe.LEAD_PIPE);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public String deleteCard(Model model, Principal principal, int card_id, int pt_id)
    {
        Pipe pipe = Pipe.valueOf(pt_id);
        Card card = new Card();

        try {
            card = cs.getById(card_id);
            cs.delete(card);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        inserAttributes(model, principal, pipe);
        return "pipeline/pipeline";
    }

    @RequestMapping(value = "/editCardName", method = RequestMethod.POST)
    public String editCardName(Model model, String cardName, int card_id, int pt_id, Principal principal)
    {
        Card card = null;
        Pipe pipe = Pipe.valueOf(pt_id);

        try {
            card = cs.getById(card_id);
            card.setCardName(cardName);
            cs.update(card);
        } catch (Exception e) {
            e.printStackTrace();
        }

        inserAttributes(model, principal, pipe);

        return "pipeline/pipeline";
    }

    private void inserAttributes(Model model, Principal principal, Pipe pipe)
    {
        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            cards = cs.getCards(principal, pipe);
            pt = pts.getPipe(pipe);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
    }
}