package evg.testt.dao.Jpa;

import evg.testt.model.Manager;
import evg.testt.dao.ManagerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerRepositoryJpaImpl extends BaseRepositoryJpaImpl<Manager> implements ManagerRepository {
}
