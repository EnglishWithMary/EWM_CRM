package evg.testt.repository.Jpa;

import evg.testt.model.CardPerson;
import evg.testt.model.Lead;
import evg.testt.repository.CardPersonRepository;
import evg.testt.repository.LeadRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardPersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<CardPerson> implements CardPersonRepository {
}
