package evg.testt.service.impl;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;
import evg.testt.dao.PersonRepository;
import evg.testt.model.State;
import evg.testt.model.StateType;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import java.util.List;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPersonByUserLogin(String userLogin) throws SQLException, PersonRoleNotFoundException {
        return dao.findPersonByUserLogin(userLogin);
    }

    @Override
    public List<Person>  getSortedByRegistrationDate() throws SQLException{
        return personRepository.findSortedByRegistrationDate();
    }

    @Override
    public void delete(Person person) throws SQLException {

        State state = new State(StateType.STATE_DELETED.getState());

        person.setState(state);
        update(person);
    }
}
