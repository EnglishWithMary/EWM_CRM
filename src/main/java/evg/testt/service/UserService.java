package evg.testt.service;

import evg.testt.model.User;

public interface UserService extends Service<User>{

    User findByUserLogin(String login);
}
