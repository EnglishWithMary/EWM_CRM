package evg.testt.service.impl;

import evg.testt.model.User;
import evg.testt.dao.UserDao;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService{

    @Autowired
    UserDao userDao;

//    public
    @Override
    public void insert(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @Override
    public User findByUserLogin(String login){
        return userDao.findByLogin(login);
    }
}
