package evg.testt.service.impl;

import evg.testt.dao.PersonRepository;
import evg.testt.model.Person;
import evg.testt.model.Personnel;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person getPersonByUserLogin(String userLogin) throws SQLException {
        Person person = dao.findPersonByUserLogin(userLogin);

        try {
            DateFormat birthdayDate = new SimpleDateFormat("yyyy-MM-dd");
            person.setBirthdayString(birthdayDate.format(person.getBirthdayDate()));
        }
        catch (NullPointerException e){}

        return person;
    }

    @Override
    public List<Person>  getSortedByRegistrationDate() throws SQLException{
        return personRepository.findSortedByRegistrationDate();
    }

    @Override
    public List<Personnel> getPersonsByKeyWord(String keyWords) throws SQLException {
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
