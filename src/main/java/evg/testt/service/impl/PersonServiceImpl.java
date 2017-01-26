package evg.testt.service.impl;

import evg.testt.dao.PersonRepository;
import evg.testt.dto.PersonDTO;
import evg.testt.model.Email;
import evg.testt.model.Person;
import evg.testt.model.Personnel;
import evg.testt.model.State;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {

    @Override
    public Person getPersonByUserLogin(String userLogin) throws SQLException {
        Person person = dao.findPersonByUserLogin(userLogin);

        if (person.getBirthdayDate() != null) {
            DateFormat birthdayDate = new SimpleDateFormat("yyyy-MM-dd");
            person.setBirthdayString(birthdayDate.format(person.getBirthdayDate()));
        }
        return person;
    }

    @Override
    public List<Person> getSortedByRegistrationDate() throws SQLException {
        return dao.findSortedByRegistrationDate();
    }

    @Override
    public List<Person> getTrashedPersons() throws SQLException {
        return dao.findTrashedPersons();
    }

    @Override
    public void update(Person o) throws SQLException {
        o.setModifyDate(new Date());
        dao.save(o);
    }

    public Person getUpdatedPerson(Person person, PersonDTO personDTO) throws ParseException, SQLException {

        if(personDTO != null) {
            if (person == null) {
                person = new Person();
            }

            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setMiddleName(personDTO.getMiddleName());
            person.setComments(personDTO.getComments());
            person.setOrganization(personDTO.getOrganization());
            person.setBirthdayDate(personDTO.getBirthdayDate());
            person.setEmail(new Email(personDTO.getEmail()));
            person.setState(new State());
        }

        return person;
    }
}
