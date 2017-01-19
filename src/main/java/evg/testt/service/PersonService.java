package evg.testt.service;

import evg.testt.model.Person;
import evg.testt.model.Personnel;
import evg.testt.model.SearchedPerson;

import java.sql.SQLException;
import java.util.List;

public interface PersonService extends Service<Person> {

    public Person getPersonByUserLogin(String userLogin) throws SQLException;

    public List<Person> getSortedByRegistrationDate() throws SQLException;

    public void delete(Person person) throws SQLException;
}
