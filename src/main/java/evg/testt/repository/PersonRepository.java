package evg.testt.repository;

import evg.testt.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository extends BaseRepository <Person>{

    public Person findPersonByUserLogin(String userLogin);


    List<Person> findSortedByRegistrationDate() throws SQLException;
}
