package evg.testt.service;

import evg.testt.model.Person;

import java.sql.SQLException;

public interface PersonService extends Service<Person> {
    @Override
    public void delete(Person person) throws SQLException;
}
