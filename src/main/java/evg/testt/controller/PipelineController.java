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
    private EntityManager em;

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
        PipeType pt = getPipe(p);

        card.setUser(user);
        card.setType(pt);

        try {
            cs.insert(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model.addAttribute("cards", getCards(principal, p));
        model.addAttribute("pt", pt);
        return JspPath.PIPELINE;
    }


    @RequestMapping(value = "/takeStudentpipe", method = RequestMethod.GET)
    public String takeStudent(Model model, Principal principal)
    {
        model.addAttribute("cards", getCards(principal, Pipe.STUDENT_PIPE));
        model.addAttribute("pt", getPipe(Pipe.STUDENT_PIPE));
        return JspPath.PIPELINE;
    }

    @RequestMapping(value = "/takeLeadtpipe", method = RequestMethod.GET)
    public String takeLead(Model model, Principal principal)
    {
        model.addAttribute("cards", getCards(principal, Pipe.LEAD_PIPE));
        model.addAttribute("pt", getPipe(Pipe.LEAD_PIPE));
        return JspPath.PIPELINE;
    }

    @RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
    public String deleteCard(Model model, Principal principal, int card_id, int pt_id)
    {
        Pipe pipe = Pipe.valueOf(pt_id);
        Card card = new Card();

        try {
            card = cs.getById(card_id);
            cs.delete(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        model.addAttribute("cards", getCards(principal, pipe));
        model.addAttribute("pt", getPipe(pipe));
        return JspPath.PIPELINE;
    }

    /*
    Get cards that related to user. With chosen pipe type.
     */
    private List<Card> getCards(Principal principal, Pipe pipe)
    {
        List<Card> cards = Collections.EMPTY_LIST;

        User user = us.findByUserLogin(principal.getName());

        Query query = em.createQuery("from cards where user_id = :uid and type_id = :tid");
        query.setParameter("uid", user.getId());
        query.setParameter("tid", pipe.getPipeId());
        cards = query.getResultList();

        return cards;
    }

    private PipeType getPipe(Pipe pipe)
    {
        PipeType pt = new PipeType();
        try {
            pt = pts.getById(pipe.getPipeId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pt;
    }
}