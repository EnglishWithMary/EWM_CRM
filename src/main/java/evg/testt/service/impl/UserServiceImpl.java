package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.model.User;
import evg.testt.dao.UserRepository;
import evg.testt.service.PersonService;
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
    @Autowired
    PersonService personService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

    public User getUpdatedUser(User user, PersonDTO personDTO){
        if(personDTO!=null) {
            if (user.getLogin() == null) {
                user.setLogin(personDTO.getLogin());
            }

            if (personDTO.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(personDTO.getPassword()));
            }
        }

        return user;
    }

}
