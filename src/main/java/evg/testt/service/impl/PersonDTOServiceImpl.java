package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.service.PersonDTOService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonDTOServiceImpl<T extends RegisteredUser> implements PersonDTOService {

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public <T extends RegisteredUser> T updateRegisteredUser(T someRegisteredUser, PersonDTO personDTO) throws SQLException, ParseException{

        someRegisteredUser.setPerson(getUpdatedPerson(someRegisteredUser.getPerson(), personDTO));

        someRegisteredUser.setUser(getUpdatedUser(someRegisteredUser.getUser(), personDTO));

        return someRegisteredUser;
    }

    public Lead updateLead(Lead lead, PersonDTO personDTO) throws ParseException{

        lead.setPerson(getUpdatedPerson(lead.getPerson(), personDTO));

        return lead;
    }

    public Person getUpdatedPerson(Person person, PersonDTO personDTO) throws ParseException {

        if(personDTO!= null) {
            if (person == Person.NULL) {
                person = new Person();
            }

            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setMiddleName(personDTO.getMiddleName());
            person.setComments(personDTO.getComments());
            person.setOrganization(personDTO.getOrganization());
            person.setBirthdayDate(getDateFromString(personDTO.getBirthdayDate()));
            person.setEmail(new Email(personDTO.getEmail()));
            person.setState(new State());
        }

        return person;
    }

    public User getUpdatedUser (User user, PersonDTO personDTO){
        if(personDTO!=null) {
            if (user.getLogin() == null) {
                user.setLogin(personDTO.getLogin());
            }

            if (personDTO.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(personDTO.getPassword()));
            }
        }

        return user;
    }

    public Date getDateFromString(String dateFromForm) throws ParseException {
        if (dateFromForm != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(dateFromForm);
            return date;
        }
        else {
            return null;
        }
    }

}