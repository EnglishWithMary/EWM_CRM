package evg.testt.dao;

import evg.testt.model.Person;
import evg.testt.model.Personnel;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository extends BaseRepository <Person>{

    Person findPersonByUserLogin(String userLogin);

    List<Person> findSortedByRegistrationDate() throws SQLException;
}
