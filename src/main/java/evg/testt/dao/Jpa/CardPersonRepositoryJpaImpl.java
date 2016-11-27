package evg.testt.dao.Jpa;

import evg.testt.model.CardPerson;
import evg.testt.dao.CardPersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardPersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<CardPerson> implements CardPersonRepository {
}
