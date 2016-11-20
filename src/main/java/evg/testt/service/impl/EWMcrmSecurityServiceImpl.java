package evg.testt.service.impl;

import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.repository.RoleRepository;
import evg.testt.repository.UserRepository;
import evg.testt.service.EWMcrmSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EWMcrmSecurityServiceImpl implements EWMcrmSecurityService {

    RoleRepository roleRepository;
    UserRepository userRepository;

    @Autowired
    public EWMcrmSecurityServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        user.setPassword(b.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    /* Security things */
    @Override
    public User getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }
    /* Roles  */

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Collection<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleRepository.findOne(id);
    }
}
