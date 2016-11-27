package evg.testt.dao.Jpa;

import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.*;
import evg.testt.dao.PersonRepository;
import evg.testt.service.PersonService;
import evg.testt.service.StateService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

import java.sql.SQLException;

@Repository
public class PersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<Person> implements PersonRepository  {

    @Autowired
    UserService userService;
    @Autowired
    PersonService personService;
    @Autowired
    StateService stateService;

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

        Query query = em.createQuery("SELECT person FROM persons person ORDER BY person.registrationDate ASC");
        List<Person> result = (List<Person>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;

    }

//    public void deletePerson(Person person) throws SQLException {
//        Query query;
//        if (hasPerson()) {
//            PersonState stateId = PersonState.STATE_DELETED;
//            State state = stateService.getById(stateId.getStateId());
//            person.setState(state);
////            query.set("state_id", stateId);
//            query = em.createQuery("UPDATE person FROM persons.state_id");
//            em.merge(Person person);
//        }
//    }


//    @Override
//    public List<Person> findAllNotDeletedPersons() throws SQLException {
//
//        Query query = em.createQuery("SELECT person FROM persons person WHERE state_id !=:id");
//        query.setParameter("id", PersonState.STATE_DELETED.getStateId());
//        List<Person> result = (List<Person>) query.getResultList();
//        if(result.size()>0) {
//            return result;
//        }
//        return null;
//
//    }

}
