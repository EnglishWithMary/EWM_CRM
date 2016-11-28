package evg.testt.repository;

import evg.testt.model.Lead;
import evg.testt.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface LeadRepository extends BaseRepository<Lead>{
    Lead findByPerson(Person person);
}
