package evg.testt.controller;

import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
import evg.testt.model.User;
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

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by DENNNN on 19.11.2016.
 */
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

        return JspPath.PIPELINE;
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(Model model, Principal principal,@RequestParam(required = true) int pt_id)
    {
        Card card = new Card();
        Pipe p = Pipe.valueOf(pt_id);
        User user = us.findByUserLogin(principal.getName());

        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            pt = pts.getPipe(p);

            card.setUser(user);
            card.setType(pt);

            cs.insert(card);

            cards = cs.getCards(principal, p);
        } catch (Exception e) {
            e.printStackTrace();
        }


        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
        return JspPath.PIPELINE;
    }


    @RequestMapping(value = "/takeStudentpipe", method = RequestMethod.GET)
    public String takeStudent(Model model, Principal principal)
    {
        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            cards = cs.getCards(principal, Pipe.STUDENT_PIPE);
            pt = pts.getPipe(Pipe.STUDENT_PIPE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
        return JspPath.PIPELINE;
    }

    @RequestMapping(value = "/takeLeadtpipe", method = RequestMethod.GET)
    public String takeLead(Model model, Principal principal)
    {
        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            cards = cs.getCards(principal, Pipe.LEAD_PIPE);
            pt = pts.getPipe(Pipe.LEAD_PIPE);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
        return JspPath.PIPELINE;
    }

    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public String deleteCard(Model model, Principal principal, int card_id, int pt_id)
    {
        Pipe pipe = Pipe.valueOf(pt_id);
        Card card = new Card();
        PipeType pt = new PipeType();
        List<Card> cards = Collections.EMPTY_LIST;

        try {
            card = cs.getById(card_id);
            cs.delete(card);

            cards = cs.getCards(principal, pipe);
            pt = pts.getPipe(pipe);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", cards);
        model.addAttribute("pt", pt);
        return JspPath.PIPELINE;
    }
}