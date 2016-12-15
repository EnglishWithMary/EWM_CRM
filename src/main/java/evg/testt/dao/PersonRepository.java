package evg.testt.dao;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;
import evg.testt.model.Role;

import java.sql.SQLException;
import java.util.List;

public interface PersonRepository extends BaseRepository <Person>{

    Person findPersonByUserLogin(String userLogin) throws PersonRoleNotFoundException;


    List<Person> findSortedByRegistrationDate() throws SQLException;

}
