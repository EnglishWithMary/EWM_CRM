package evg.testt.service.impl;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Person;
import evg.testt.model.PersonState;
import evg.testt.model.State;

import evg.testt.repository.PersonRepository;
import evg.testt.service.PersonService;
import evg.testt.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {
    @Autowired
    StateService stateService;
    @Autowired
    PersonService personService;
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
    public void insert(Person person) throws SQLException {
        PersonState stateId = PersonState.STATE_ACTIVE;
        State state = stateService.getById(stateId.getStateId());
        person.setState(state);
        update(person);
    }

    @Override
    public void delete(Person person) throws SQLException {
        PersonState stateId = PersonState.STATE_DELETED;
        State state = stateService.getById(stateId.getStateId());
        person.setState(state);
        update(person);
    }

    @Override
    public List<Person> getAll() throws SQLException {
        return personRepository.findAllNotDeletedPersons();
    }
}
