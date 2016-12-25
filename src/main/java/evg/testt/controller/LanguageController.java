package evg.testt.controller;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Language;
import evg.testt.model.Room;
import evg.testt.model.Teacher;
import evg.testt.model.User;
import evg.testt.oval.SpringOvalValidator;
import evg.testt.service.*;
import org.apache.commons.codec.language.bm.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.List;

@Controller
@PropertySource(value = "classpath:standard.properties")
public class LanguageController {

    @Autowired(required = false)
    SpringOvalValidator validator;
    @Autowired
    TeacherService teacherService;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    PersonService personService;
    @Autowired
    PersonDTOService personDTOService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private LanguageService languageService;


    @RequestMapping(value = "/languages", method = RequestMethod.GET)
    public String showLanguages(@RequestParam(required = false) Integer page,
                                @RequestParam(required = false) Boolean flagSorted,
                                Model model) throws SQLException {

        List<Language> languages = languageService.getAll();

        model.addAttribute("languages", languages);
        return "languages/all";
    }

    @RequestMapping(value = "/languageAdd")
    public String addLanguage(Model model) {
        Language language = new Language();
        model.addAttribute("language", language);
        return "languages/add";
    }

    @RequestMapping(value = "/languageSave", method = RequestMethod.POST)
    public String saveLanguage(Model model, @ModelAttribute("language")
    @Validated Language language, BindingResult result)
            throws SQLException, IOException {
        if (result.hasErrors()) {
            return "languages/add";
        }
        languageService.insert(language);
        return "redirect:/languages";
    }

    @RequestMapping(value = "/languageDel")
    public String delLanguage(Model model, @ModelAttribute("language")
    @Validated Language language, BindingResult result)
            throws SQLException, IOException {
        languageService.delete(language);
        return "redirect:/languages";
    }

}


