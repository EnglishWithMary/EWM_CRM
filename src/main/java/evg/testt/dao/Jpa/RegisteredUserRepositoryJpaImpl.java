package evg.testt.dao.Jpa;

import evg.testt.dao.HumanRepository;
import evg.testt.model.RegisteredUser;
import org.springframework.stereotype.Repository;

@Repository
public abstract class RegisteredUserRepositoryJpaImpl<T extends RegisteredUser>
        extends HumanRepositoryJpaImpl<T> implements HumanRepository<T> {
}
