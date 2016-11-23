package evg.testt.service.impl;

import evg.testt.model.User;
import evg.testt.repository.UserRepository;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseService<User, UserRepository> implements UserService{

    @Autowired
    UserRepository userRepository;

//    public
    @Override
    public void insert(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @Override
    public User findByUserLogin(String login){
        return userRepository.findByLogin(login);
    }
}
