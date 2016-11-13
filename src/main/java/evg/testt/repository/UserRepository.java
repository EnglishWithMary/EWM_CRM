package evg.testt.repository;

import evg.testt.model.User;

import java.util.Collection;

public interface UserRepository {

    Collection<User> getAll();

    User findById(Integer id);

    User findByLogin(String login);

    void save(User user);
}
