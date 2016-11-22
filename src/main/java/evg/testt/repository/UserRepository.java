package evg.testt.repository;

import evg.testt.model.User;

public interface UserRepository extends BaseRepository<User>{

    User findByLogin(String login);
}
