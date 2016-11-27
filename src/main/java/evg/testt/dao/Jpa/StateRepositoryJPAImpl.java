package evg.testt.dao.Jpa;

import evg.testt.dao.StateRepository;
import evg.testt.model.State;
import org.springframework.stereotype.Repository;


@Repository
public class StateRepositoryJPAImpl extends BaseRepositoryJpaImpl<State> implements StateRepository {
}
