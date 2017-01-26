package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Person;
import evg.testt.model.Personnel;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface PersonService extends Service<Person> {

    Person getPersonByUserLogin(String userLogin) throws SQLException;

    List<Person> getSortedByRegistrationDate() throws SQLException;

    void delete(Person person) throws SQLException;

    List<Person> getTrashedPersons() throws SQLException;

    Person getUpdatedPerson(Person person, PersonDTO personDTO) throws ParseException, SQLException;
}
