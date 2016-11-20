package evg.testt.repository.Jpa;

import evg.testt.model.Group;
import evg.testt.repository.GroupRepository;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRepositoryJpaImpl extends BaseRepositoryJpaImpl<Group> implements GroupRepository {
}
