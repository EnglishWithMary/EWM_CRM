package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;

import java.sql.SQLException;
import java.text.ParseException;

public interface PersonDTOService {

    <T extends RegisteredUser> T updateRegisteredUser(T someRegisteredUser, PersonDTO personDTO) throws SQLException, ParseException;

    Person getUpdatedPerson(Person person, PersonDTO personDTO) throws ParseException;

    User getUpdatedUser (User user, PersonDTO personDTO);

    Lead updateLead(Lead lead, PersonDTO personDTO) throws ParseException;

    Teacher getUpdateTeacher(Teacher teacher, PersonDTO personDTO)throws ParseException;
}
