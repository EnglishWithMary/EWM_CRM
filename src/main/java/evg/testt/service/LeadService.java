package evg.testt.service;

import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface LeadService extends HumanService<Lead> {

    Lead getByPerson(Person person) throws SQLException;

    Lead getLeadByPersonId(Integer personId);

}
