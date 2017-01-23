package evg.testt.controller;

import evg.testt.model.Person;
import evg.testt.model.State;
import evg.testt.model.StateType;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
public class TrashController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/trash")
    public String trash(Model model) throws SQLException {
        List<Person> trashedPersons = personService.getTrashedPersons();
        model.addAttribute("persons", trashedPersons);
        return "trash/all";
    }

    @ResponseBody
    @RequestMapping(value = "/trash/restore", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> revert(@RequestBody Integer person_id) throws SQLException {
        if(person_id != null) {
            Person person = personService.getById(person_id);
            person.setState(new State(StateType.STATE_ACTIVE));
            personService.update(person);
            return ResponseEntity.ok("{}");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @ResponseBody
    @RequestMapping(value = "/trash/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@RequestBody Integer person_id) throws SQLException {
        if(person_id != null) {
            Person person = personService.getById(person_id);
            person.setState(new State(StateType.STATE_DELETED));
            personService.update(person);
            return ResponseEntity.ok("{}");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}