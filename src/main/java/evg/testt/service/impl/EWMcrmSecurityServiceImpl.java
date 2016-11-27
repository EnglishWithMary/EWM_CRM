package evg.testt.service.impl;

import evg.testt.model.Role;
import evg.testt.model.User;
import evg.testt.dao.RoleDao;
import evg.testt.dao.UserDao;
import evg.testt.service.EWMcrmSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EWMcrmSecurityServiceImpl implements EWMcrmSecurityService {

    RoleDao roleDao;
    UserDao userDao;

    @Autowired
    public EWMcrmSecurityServiceImpl(RoleDao roleDao, UserDao userDao) {
        this.roleDao = roleDao;
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        user.setPassword(b.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findOne(id);
    }

    /* Security things */
    @Override
    public User getUserByLogin(String login){
        return userDao.findByLogin(login);
    }
    /* Roles  */

    @Override
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public Collection<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.findOne(id);
    }
}
