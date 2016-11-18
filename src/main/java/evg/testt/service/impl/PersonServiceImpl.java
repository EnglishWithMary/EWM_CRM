package evg.testt.service.impl;

import evg.testt.dao.PersonDao;
import evg.testt.model.Person;
import evg.testt.service.PersonService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonDao> implements PersonService {

    @Override
    public void insert(Person o) throws SQLException {
        Date currentDate= new Date();
        o.setRegistrationDate(currentDate);
        dao.save(o);
    }

}
