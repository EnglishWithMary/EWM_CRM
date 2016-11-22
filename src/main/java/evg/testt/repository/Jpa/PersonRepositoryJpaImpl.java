package evg.testt.repository.Jpa;

import evg.testt.model.*;
import evg.testt.repository.PersonRepository;
import evg.testt.service.PersonService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

@Repository
public class PersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<Person> implements PersonRepository{

    @Autowired
    UserService userService;

    @Autowired
    PersonService personService;

    @Override
    public Person findPersonByUserLogin(String userLogin) {

        User user = userService.findByUserLogin(userLogin);

        Role role = user.getRole();
        Query query;
        switch (role.getRole()){
            case "ROLE_ADMIN":
                query = em.createQuery("SELECT admin FROM admins admin WHERE user_id =:id");
                query.setParameter("id", user.getId());
                return ((Admin) query.getSingleResult()).getPerson();
            case "ROLE_MANAGER":
                query = em.createQuery("SELECT manager FROM managers manager WHERE user_id =:id");
                query.setParameter("id", user.getId());
                return ((Manager) query.getSingleResult()).getPerson();
        }
        return null;
    }
}
