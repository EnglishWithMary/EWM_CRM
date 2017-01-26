package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.RegisteredUser;
import evg.testt.model.User;

import java.sql.SQLException;
import java.text.ParseException;

public interface PersonDTOService {

    PersonDTO getUpdatedPersonDTO (PersonDTO personDTO, Integer personId, Integer cardId) throws SQLException;
}
