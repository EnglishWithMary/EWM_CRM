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

import java.util.Date;
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
    public List<Person> getPersonsByKeyWord(String keyWords) throws SQLException {
        StringBuilder searchText = new StringBuilder();

        String[] words = keyWords.split("\\s");

        for (int i = 0; i < words.length; i++) {
            searchText.append(words[i] + ":*");
            if (i < words.length - 1)
                searchText.append("|");
        }

        return dao.findPersonByKeyWord(searchText.toString());
    }

    @Override
    public void update(Person o) throws SQLException {
        o.setModifyDate(new Date());
        dao.save(o);
    }
}
