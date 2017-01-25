package evg.testt.dao;

import evg.testt.model.Lead;
import evg.testt.model.Person;

public interface LeadRepository extends HumanRepository<Lead>{
    Lead findByPerson(Person person);

    Lead findLeadByPersonId(Integer personId);
}
