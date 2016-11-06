package evg.testt.service.impl;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.sql.SQLException;

/**
 * Created by clay on 25.09.16.
 */

@Service
@Transactional
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void insert(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @Override
    public User getByLogin(String login) throws SQLException {
        User u = null;
        //HQL
        //JPQL
        u = em.createQuery("select u User", User.class).getSingleResult();
        return null;
    }
}
