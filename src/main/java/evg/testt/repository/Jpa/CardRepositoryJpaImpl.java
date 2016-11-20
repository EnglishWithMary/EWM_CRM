package evg.testt.repository.Jpa;

import evg.testt.model.Card;
import evg.testt.model.Manager;
import evg.testt.repository.CardRepository;
import evg.testt.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CardRepositoryJpaImpl extends BaseRepositoryJpaImpl<Card> implements CardRepository {
}
