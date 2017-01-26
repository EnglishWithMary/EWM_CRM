package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;

import java.sql.SQLException;
import java.text.ParseException;

public interface PersonDTOService {

    PersonDTO getUpdatedPersonDTO (PersonDTO personDTO, Integer personId, Integer cardId) throws SQLException;
}
