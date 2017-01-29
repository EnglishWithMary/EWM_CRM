package evg.testt.service.impl;

import evg.testt.dao.HumanRepository;
import evg.testt.dao.RegisteredUserRepository;
import evg.testt.dto.PersonDTO;
import evg.testt.model.Human;
import evg.testt.model.Person;
import evg.testt.model.RegisteredUser;
import evg.testt.model.User;
import evg.testt.service.HumanService;
import evg.testt.service.PersonService;
import evg.testt.service.RegisteredUserService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;

@Service
public abstract
class RegisteredUserServiceImpl<T extends RegisteredUser, P extends RegisteredUserRepository<T>>
        extends HumanServiceImpl<T, P> implements RegisteredUserService<T> {

    @Autowired
    PersonService personService;
    @Autowired
    UserService userService;

    public T updateRegisteredUser(T someRegisteredUser, PersonDTO personDTO)
            throws SQLException, ParseException {

        Person person = personService.getUpdatedPerson(someRegisteredUser.getPerson(), personDTO);

        User user = userService.getUpdatedUser(someRegisteredUser.getUser(),personDTO);

        someRegisteredUser.setPerson(person);
        someRegisteredUser.setUser(user);

        return someRegisteredUser;
    }
}