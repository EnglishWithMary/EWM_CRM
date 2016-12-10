package evg.testt.dao.Jpa;

import evg.testt.dao.BaseRepository;
import evg.testt.model.Human;
import evg.testt.model.Manager;
import evg.testt.dao.ManagerRepository;
import evg.testt.model.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerRepositoryJpaImpl extends RegisteredUserRepositoryJpaImpl<Manager>
        implements ManagerRepository {
}
