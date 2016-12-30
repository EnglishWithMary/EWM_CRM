package evg.testt.dao.Jpa;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.*;
import evg.testt.dao.PersonRepository;
import evg.testt.service.PersonService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.sql.SQLException;

@Repository
public class PersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<Person> implements PersonRepository  {

    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;

    @Override
    public Person findPersonByUserLogin(String userLogin) throws PersonRoleNotFoundException {

        User user = userService.findByUserLogin(userLogin);
        Role role = user.getRole();
        Query query;

        switch(role.getRole()) {
        case "ROLE_ADMIN":
            query = em.createQuery("SELECT admin FROM admins admin WHERE user_id =:id");
            query.setParameter("id", user.getId());
            return ((Admin) query.getSingleResult()).getPerson();
        case "ROLE_MANAGER":
            query = em.createQuery("SELECT manager FROM managers manager WHERE user_id =:id");
            query.setParameter("id", user.getId());
            return ((Manager) query.getSingleResult()).getPerson();
        case "ROLE_TEACHER":
            query = em.createQuery("SELECT teacher FROM teachers teacher WHERE user_id =:id");
            query.setParameter("id", user.getId());
            return ((Teacher) query.getSingleResult()).getPerson();
        case "ROLE_STUDENT":
            query = em.createQuery("SELECT student FROM students student WHERE user_id =:id");
            query.setParameter("id", user.getId());
            return ((Student) query.getSingleResult()).getPerson();
        default:
            throw new PersonRoleNotFoundException("Such Role of Person is unknown. Go to PersonRepositoryJpaImpl and add new handler.");
        }
    }

    @Override
    public List<Person> findSortedByRegistrationDate() throws SQLException {

        Query query = em.createQuery("UPDATE person.state FROM persons person ");
        List<Person> result = (List<Person>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;
    }

    @Override
    public List<Person> findPersonByKeyWord(String keywords) throws SQLException {
        List<Person> peoples = Collections.EMPTY_LIST;

        String searchText = keywords+":*";

        Query nativeQuery = em.createNativeQuery("SELECT * FROM persons WHERE fts @@ to_tsquery(:text)", Person.class);
        nativeQuery.setParameter("text", searchText);
        peoples = nativeQuery.getResultList();

        return peoples;
    }

}
