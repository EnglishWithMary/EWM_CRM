package evg.testt.service;

import evg.testt.model.Role;
import evg.testt.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public interface EWMcrmSecurityService {

    void saveUser(User user);

    Collection<User > getAllUsers();

    User getUserById(Integer id);

    User getUserByLogin(String login);

    void saveRole(Role role);

    Collection<Role> getAllRoles();

    Role getRoleById(Integer id);

}
