package evg.testt.dao.Jpa;

import evg.testt.dao.CardDao;
import evg.testt.model.Card;
import org.springframework.stereotype.Repository;

@Repository
public class CardDaoJpaImpl extends BaseDaoJpaImpl<Card> implements CardDao {
}
