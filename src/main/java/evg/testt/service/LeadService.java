package evg.testt.service;

import evg.testt.model.Lead;
import evg.testt.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface LeadService extends HumanService<Lead> {

    Lead getByPerson(Person person) throws SQLException;

}
