package evg.testt.repository;

import evg.testt.model.Person;

public interface PersonRepository {

    Person findPersonById(Integer id);

    Integer save(Person person);
}
