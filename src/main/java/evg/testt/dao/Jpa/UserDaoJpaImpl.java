package evg.testt.dao.Jpa;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoJpaImpl extends BaseDaoJpaImpl<User> implements UserDao {

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
