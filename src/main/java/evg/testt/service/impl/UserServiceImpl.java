package evg.testt.service.impl;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by clay on 25.09.16.
 */

@Service
@Transactional
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService{

    @Override
    public void insert(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }
}
