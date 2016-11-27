package evg.testt.dao;

import evg.testt.model.User;

public interface UserDao extends BaseDao<User> {

    User findByLogin(String login);
}
