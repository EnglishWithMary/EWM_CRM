package evg.testt.repository.Jpa;

import evg.testt.model.User;
import evg.testt.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryJpaImpl extends BaseRepositoryJpaImpl<User> implements UserRepository {

    @Override
    public User findByLogin(String login) {
        Query query = em.createQuery("SELECT user FROM users user WHERE user.login =:login");
        query.setParameter("login", login);
        List<User> result = (List<User>) query.getResultList();
        if(result.size()>0) {
            return (User) result.toArray()[0];
        }else {
            return null;
        }
    }

}
