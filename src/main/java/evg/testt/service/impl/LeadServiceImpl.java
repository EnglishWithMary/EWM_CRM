package evg.testt.service.impl;

import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.dao.LeadRepository;
import evg.testt.service.LeadService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class LeadServiceImpl extends BaseService<Lead, LeadRepository> implements LeadService {
    @Override
    public Lead getByPerson(Person person) throws SQLException {
        return dao.findByPerson(person);
    }
}