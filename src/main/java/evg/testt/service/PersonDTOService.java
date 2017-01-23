package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.RegisteredUser;
import evg.testt.model.User;

import java.sql.SQLException;
import java.text.ParseException;

public interface PersonDTOService {

    <T extends RegisteredUser> T updateRegisteredUser(T someRegisteredUser, PersonDTO personDTO) throws SQLException, ParseException;

    Person getUpdatedPerson(Person person, PersonDTO personDTO) throws ParseException;

    PersonDTO getUpdatedPersonDTO (PersonDTO personDTO, Integer personId, Integer cardId) throws SQLException;

    User getUpdatedUser (User user, PersonDTO personDTO);

    Lead updateLead(Lead lead, PersonDTO personDTO) throws ParseException;
}
