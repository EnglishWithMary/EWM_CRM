package evg.testt.service.impl;

import evg.testt.model.Person;
import evg.testt.repository.PersonRepository;
import evg.testt.service.PersonService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {

    @Override
    public Person getPersonByUserLogin(String userLogin) throws SQLException{
        return dao.findPersonByUserLogin(userLogin);
    }
}
