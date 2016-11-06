package evg.testt.dao;


import evg.testt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;

public interface UserDao extends JpaRepository<User, Integer> {
}
