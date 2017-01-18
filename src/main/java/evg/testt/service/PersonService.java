package evg.testt.service;

import evg.testt.model.Person;
import evg.testt.model.Personnel;

import java.sql.SQLException;
import java.util.List;

public interface PersonService extends Service<Person> {

    public Person getPersonByUserLogin(String userLogin) throws SQLException/*, PersonRoleNotFoundException*/;

    public List<Person> getSortedByRegistrationDate() throws SQLException;

    public void delete(Person person) throws SQLException;

    List<Personnel> getPersonsByKeyWord(String keyWords) throws SQLException;

}
