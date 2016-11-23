package evg.testt.service;

import evg.testt.model.Person;

import java.sql.SQLException;

public interface PersonService extends Service<Person> {

    public Person getPersonByUserLogin(String userLogin) throws SQLException;
}
