package evg.testt.service;

import evg.testt.model.User;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;

/**
 * Created by clay on 25.09.16.
 */
public interface UserService extends Service<User>{
    public User getByLogin(String login) throws SQLException;
}
