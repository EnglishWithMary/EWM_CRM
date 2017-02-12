package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Controller
public class LeadController {

    @Autowired
    private PipeTypeService pipeTypeService;
    @Autowired
    private CardService cardService;
    @Autowired
    private LeadService leadService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private PersonService personService;
    @Autowired(required = false)
    private EmailService emailService;
    @Autowired
    private PersonDTOService personDTOService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/leads", method = RequestMethod.GET)
    public String showLeads(@RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Boolean flagSorted,
                            Model model) throws SQLException {

        if (flagSorted == null) flagSorted = false;

        int totalLeads;
        int pages;
        int currentPage = 1;

        if (page != null && page > 0) {
            currentPage = page;
        }

        totalLeads = leadService.count();

        List<Lead> leads = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            leads = leadService.getByPage(currentPage);
        } else {
            leads = leadService.getByPageSorted(currentPage);
        }

        pages = ((totalLeads / pageSize) + 1);

        if (totalLeads % pageSize == 0)
            pages--;

        model.addAttribute("leads", leads);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "leads/all";
    }

    @RequestMapping(value = "/leads/SortByDate", method = RequestMethod.POST)
    public String filterLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getSortedByRegistrationDate();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leads/add", method = RequestMethod.POST)
    public String leadAdd(HttpServletRequest request, Model model,
                                @RequestParam(required = false) Integer cardId,
                                @RequestParam(required = false) Integer personId
    ) throws SQLException {
        request.getSession().setAttribute("callback", request.getHeader("Referer"));

        PersonDTO personDTO = personDTOService.getUpdatedPersonDTO(new PersonDTO(), personId, cardId);

        model.addAttribute("lead", personDTO);
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));
        model.addAttribute("personId", personId);

        return "leads/add";
    }

    @RequestMapping(value = "/leads/save", method = RequestMethod.POST)
    public String leadSave(HttpServletRequest request, Model model,
                                 @ModelAttribute("lead") @Valid PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(required = false) Integer personId
    ) throws SQLException, ParseException {

        if (bindingResult.hasErrors()) {
            model.addAttribute("personId", personId);
            return "leads/add";
        }

//      Read Existing student or get new Student()
        Lead lead = leadService.getLeadByPersonId(personId);

        lead = leadService.updateLead(lead, personDTO);

        leadService.update(lead);

        leadService.updatePosition(lead, personDTO);

        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));
        return "redirect:" + request.getSession().getAttribute("callback").toString();
    }

    @RequestMapping(value = "/leads/delete", method = RequestMethod.POST)
    public String deleteLead(HttpServletRequest request, Model model,
                             @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        leadService.delete(lead);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/leads/trash", method = RequestMethod.POST)
    public String leadTrash(HttpServletRequest request, Model model,
                            @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        leadService.trash(lead);

        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/lead/DeleteFromPipe", method = RequestMethod.POST)
    public String leadDeleteFromPipe(HttpServletRequest request, Model model,
                                     @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        Card cardNew = cardService.getById(1);
        cardNew.getPersons().add(person);
        cardService.update(cardNew);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "/leads/info", method = RequestMethod.GET)
    public String leadInfo(Model model, @RequestParam int personId) throws SQLException {
        Lead lead = leadService.getLeadByPersonId(personId);
        Card currentCard = cardService.getCardByPerson(lead.getPerson());
        List<Card> personCardList = cardService.getCards(Pipe.LEAD_PIPE);
        model.addAttribute("currentCard", currentCard);
        model.addAttribute("personCardList", personCardList);
        model.addAttribute("lead", lead);
        return "persons/lead-info";
    }

    @RequestMapping(value = "/lead/UpdateComments", method = RequestMethod.POST)
    public String leadUpdate(Model model,
                                @RequestParam Integer personId,
                                @RequestParam String comments) throws SQLException {
        Lead lead = leadService.getLeadByPersonId(personId);
        lead.getPerson().setComments(comments);
        leadService.update(lead);
        model.addAttribute("lead", lead);

        return "persons/lead-info";
    }

    @RequestMapping(value = "/leads/ToStudent")
    public String leadToStudent(Model model, Integer personId) throws SQLException, ParseException {

        Student student = new Student();
        Lead lead = leadService.getLeadByPersonId(personId);

        lead.getPerson().setId(null);
        lead.getPerson().getEmail().setId(null);
        student.setPerson(lead.getPerson());

        leadService.delete(lead);

        studentService.insert(student);

        model.addAttribute("student", student);
        return "persons/student-info";
    }
}