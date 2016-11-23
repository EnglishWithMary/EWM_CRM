package evg.testt.service;

import evg.testt.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService extends Service<Person> {

    public List<Person> getSortedByRegistrationDate() throws SQLException;
}
