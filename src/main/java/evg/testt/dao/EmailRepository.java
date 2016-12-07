package evg.testt.dao;

import evg.testt.model.Email;
import evg.testt.model.Person;

import java.sql.SQLException;

public interface EmailRepository extends BaseRepository<Email> {
    Email findByPerson(Person person) throws SQLException;
}
