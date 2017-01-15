package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LeadController {

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
    private StudentService studentService;
    @Autowired (required = false)
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

        int totalLeads = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

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

    @RequestMapping(value = "/leadSortByDate", method = RequestMethod.POST)
    public String filterLeads(Model model) throws SQLException {
        List<Lead> leads = leadService.getSortedByRegistrationDate();
        model.addAttribute("leads", leads);
        return "leads/all";
    }

    @RequestMapping(value = "/leadAdd", method = RequestMethod.POST)
    public String addLeadOnPipe(HttpServletRequest request,Model model,
                                @RequestParam(required = false) Integer cardId,
                                @RequestParam(required = false) Integer personId
    ) throws SQLException {
        request.getSession().setAttribute("callback", request.getHeader("Referer"));
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));
        model.addAttribute("personId", personId);
        PersonDTO lead = new PersonDTO();
        if (personId != null) {
            Person person = personService.getById(personId);
            lead.setFirstName(person.getFirstName());
            lead.setMiddleName(person.getMiddleName());
            lead.setLastName(person.getLastName());
            lead.setAvatarURL(person.getAvatarURL());
            lead.setEmail(person.getEmail().getEmail());
            Card card=cardService.getCardByPerson(person);
            cardId=card.getId();
            lead.setCardId(cardId);
        }else{
            if (cardId==null) cardId=1;
            lead.setCardId(cardId);
        }
        model.addAttribute("lead", lead);
        return "leads/add";
    }

    @RequestMapping(value = "/leadSave", method = RequestMethod.POST)
    public String saveLeadOnPipe(HttpServletRequest request, Model model,
                                 @ModelAttribute("lead") @Valid PersonDTO personDTO,
                                 BindingResult bindingResult,
                                 @RequestParam(required = false) Integer personId
    ) throws SQLException, ParseException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));
//        validator.validate(personDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("personId",personId);
            return "leads/add";
        }

        if (personId==null) {
            Card card = cardService.getById(personDTO.getCardId());
            Lead lead = new Lead();
            lead = personDTOService.updateLead(lead, personDTO);
            lead.getPerson().setPosition(card.getPersons().size() + 1);
            leadService.insert(lead);
            card.getPersons().add(lead.getPerson());
            cardService.update(card);
        }else{
            Person person=personService.getById(personId);
            Card cardOld = cardService.getCardByPerson(person);
            Lead lead = leadService.getByPerson(person);
            lead = personDTOService.updateLead(lead, personDTO);
            lead.getPerson().setPosition(cardOld.getPersons().size() + 1);
            leadService.update(lead);
            if (!personDTO.getCardId().equals(cardOld.getId())) {
                cardOld.getPersons().remove(person);
                cardService.update(cardOld);
                Card cardNew = cardService.getById(personDTO.getCardId());
                cardNew.getPersons().add(person);
                cardService.update(cardNew);
            }
        }
        return "redirect:"+request.getSession().getAttribute("callback").toString();
    }

    @RequestMapping(value = "/deleteLead", method = RequestMethod.POST)
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
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "/leadTrash", method = RequestMethod.POST)
    public String leadTrash(HttpServletRequest request,Model model,
                            @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Lead lead = leadService.getByPerson(person);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        leadService.trash(lead);

        return "redirect:"+request.getHeader("Referer");
    }
    @RequestMapping(value = "/leadDeleteFromPipe", method = RequestMethod.POST)
    public String leadDeleteFromPipe(HttpServletRequest request,Model model,
                                     @RequestParam(required = true) Integer personId) throws SQLException {
        model.addAttribute("cards", cardService.getCards(Pipe.LEAD_PIPE));
        model.addAttribute("pipeType", pipeTypeService.getPipe(Pipe.LEAD_PIPE));

        Person person = personService.getById(personId);
        Card card = cardService.getCardByPerson(person);
        card.getPersons().remove(person);
        cardService.update(card);
        Card cardNew=cardService.getById(1);
        cardNew.getPersons().add(person);
        cardService.update(cardNew);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "/lead/info", method = RequestMethod.GET)
    public String leadInfo(Model model, @RequestParam int lead_Id) throws SQLException {
        Lead lead = leadService.getById(lead_Id);
        model.addAttribute("lead", lead);
        return "persons/lead-info";
    }

    @RequestMapping(value = "/leadToStudent")
    public String leadToStudent(Model model, Integer person_Id) throws SQLException, ParseException {

        Person person = personService.getById(person_Id);

        Lead lead = leadService.getByPerson(person);
        leadService.delete(lead);

        PersonDTO studentDTO = new PersonDTO();
        studentDTO.setFirstName(person.getFirstName());
        studentDTO.setMiddleName(person.getMiddleName());
        studentDTO.setLastName(person.getLastName());
        studentDTO.setEmail(person.getEmail().getEmail());
        studentDTO.setComments(person.getComments());
        studentDTO.setOrganization(person.getOrganization());
        studentDTO.setAvatarURL(person.getAvatarURL());
        //Почему у DTO нет сеттеров для некоторых полей (для телефона, например)?

        //В DTO для birthdayDate заложен String, а в Person - Date
        Date birthdayDate = person.getBirthdayDate();
        if (birthdayDate != null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String stringBirthdayDate = dateFormat.format(birthdayDate);
            studentDTO.setBirthdayDate(stringBirthdayDate);
        }

        Student student = new Student();

        personDTOService.updateRegisteredUser(student, studentDTO);
        studentService.insert(student);

        // почему не работает?
        //Integer student_Id = student.getId();
        //return "redirect:/student/info"+student_Id;

        model.addAttribute("student", student);
        return "persons/student-info";

    }

}