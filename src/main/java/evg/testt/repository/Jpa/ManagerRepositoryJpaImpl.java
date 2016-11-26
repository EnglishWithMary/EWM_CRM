package evg.testt.repository.Jpa;

import evg.testt.model.Manager;
import evg.testt.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ManagerRepositoryJpaImpl extends BaseRepositoryJpaImpl<Manager> implements ManagerRepository {
}
