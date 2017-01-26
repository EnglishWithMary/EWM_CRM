package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.RegisteredUser;

import java.sql.SQLException;
import java.text.ParseException;

public interface RegisteredUserService<T extends RegisteredUser> extends HumanService <T> {

    T updateRegisteredUser(T someRegisteredUser, PersonDTO personDTO) throws SQLException, ParseException;

}