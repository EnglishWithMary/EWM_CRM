package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
//import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @Autowired
    PersonDTOService personDTOService;

    @Value("${pagination.page.size}")
    protected int pageSize;

    @RequestMapping(value = "/managers", method = RequestMethod.GET)
    public String showManagers(@RequestParam(required = false) Integer page,
                               @RequestParam(required = false) Boolean flagSorted,
                               Model model) throws SQLException {

        if (flagSorted == null) flagSorted = false;

        int totalManagers = 0, pages = 0, currentPage = 1;

        if (page != null)
            if (page > 0)
                currentPage = page;

        totalManagers = managerService.count();

        List<Manager> managers = Collections.EMPTY_LIST;
        if (flagSorted == false) {
            managers = managerService.getByPage(currentPage);
        } else {
            managers = managerService.getByPageSorted(currentPage);
        }

        pages = ((totalManagers / pageSize) + 1);

        if (totalManagers % pageSize == 0)
            pages--;

        model.addAttribute("managers", managers);
        model.addAttribute("pages", pages);
        model.addAttribute("flagSorted", flagSorted);
        return "managers/all";
    }

    @RequestMapping(value = "/managerAdd")
    public String addManager(Model model) {
        PersonDTO person = new PersonDTO();
        model.addAttribute("manager", person);
        return "managers/add";
    }

    @RequestMapping(value = "/managerSave", method = RequestMethod.POST)
    public String saveManager(@ModelAttribute("manager") @Valid PersonDTO personDTO,
                              BindingResult bindingResult, Model model) throws SQLException, ParseException {
        User u = userService.findByUserLogin(personDTO.getLogin());

        if (u != null)
            bindingResult.rejectValue("login", "1", "Login already exist.");

        if (!bindingResult.hasErrors()) {

            Manager manager = new Manager();
            manager = personDTOService.updateRegisteredUser(manager, personDTO);
            managerService.insert(manager);

            return "redirect:/managers";
        } else {
            return "managers/add";
        }
    }

    @RequestMapping(value = "/managerDelete")
    public String managerDelete(@RequestParam Integer id) throws SQLException {
        Manager manager = managerService.getById(id);
        managerService.delete(manager);
        return "redirect:/managers";
    }

    @RequestMapping(value = "/managerTrash")
    public String managerTrash(@RequestParam Integer id) throws SQLException {
        Manager manager = managerService.getById(id);
        managerService.trash(manager);
        return "redirect:/managers";
    }

    @RequestMapping(value = "/managers/info", method = RequestMethod.GET)
    public String managerInfo(Model model, @RequestParam int manager_id) throws SQLException {
        Manager manager = managerService.getById(manager_id);
        model.addAttribute("manager", manager);
        return "persons/manager-info";
    }

    @RequestMapping(value = "/managerUpdateComments", method = RequestMethod.POST)
    public String studentUpdate(Model model,
                                @RequestParam Integer id,
                                @RequestParam String comments) throws SQLException {
        Manager manager = managerService.getById(id);
        manager.getPerson().setComments(comments);
        managerService.update(manager);
        model.addAttribute("manager", manager);

        return "persons/manager-info";
    }
}
