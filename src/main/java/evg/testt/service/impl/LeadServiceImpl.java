package evg.testt.service.impl;

import evg.testt.dao.LeadRepository;
import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.service.LeadService;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;

@Service
public class LeadServiceImpl extends HumanServiceImpl<Lead, LeadRepository> implements LeadService {

    @Autowired
    PersonService personService;

    @Override
    public Lead getByPerson(Person person) throws SQLException {
        return dao.findByPerson(person);
    }

    @Override
    public Lead getLeadByPersonId(Integer personId){
        return dao.findLeadByPersonId(personId);
    }

    @Override
    public Lead updateLead(Lead lead, PersonDTO personDTO) throws ParseException, SQLException {

        Person person = personService.getUpdatedPerson(lead.getPerson(), personDTO);

        lead.setPerson(person);

        return lead;
    }
}