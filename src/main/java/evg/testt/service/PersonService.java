package evg.testt.service;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;

import java.sql.SQLException;

import java.util.List;

public interface PersonService extends Service<Person> {

    public Person getPersonByUserLogin(String userLogin) throws SQLException, PersonRoleNotFoundException;

    public List<Person> getSortedByRegistrationDate() throws SQLException;

    public void delete(Person person) throws SQLException;

    public void insert(Person person) throws SQLException;


}
