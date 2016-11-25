package evg.testt.dao;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao extends BaseDao<Person> {

    public Person findPersonByUserLogin(String userLogin) throws PersonRoleNotFoundException;

    List<Person> findSortedByRegistrationDate() throws SQLException;
}
