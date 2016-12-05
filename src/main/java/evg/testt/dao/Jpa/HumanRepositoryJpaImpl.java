package evg.testt.dao.Jpa;


import evg.testt.dao.HumanRepository;
import evg.testt.model.Human;
import evg.testt.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public abstract class HumanRepositoryJpaImpl<T extends Human> extends BaseRepositoryJpaImpl<T>
        implements HumanRepository<T>{
}
