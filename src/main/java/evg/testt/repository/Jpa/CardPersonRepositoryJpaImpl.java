package evg.testt.repository.Jpa;

import evg.testt.model.CardPerson;
import evg.testt.repository.CardPersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardPersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<CardPerson> implements CardPersonRepository {
}
