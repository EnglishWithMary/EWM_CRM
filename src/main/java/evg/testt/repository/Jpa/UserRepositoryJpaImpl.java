package evg.testt.repository.Jpa;

import evg.testt.model.User;
import evg.testt.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class UserRepositoryJpaImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<User> getAll() {
        Query query = em.createQuery("SELECT user FROM users user LEFT JOIN FETCH " +
                "user.roles");
        return query.getResultList();
    }

    @Override
    public User findById(Integer id) {
        Query query = em.createQuery("SELECT user FROM users user LEFT JOIN FETCH " +
                "user.roles WHERE user.id =:id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

    @Override
    public User findByLogin(String login) {
        Query query = em.createQuery("SELECT user FROM users user WHERE user.login =:login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public void save(User user) {
        if(user.getId() == null){
            em.persist(user);
        } else {
            em.merge(user);
        }
    }
}
