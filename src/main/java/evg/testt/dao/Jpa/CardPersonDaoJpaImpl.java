package evg.testt.dao.Jpa;

import evg.testt.dao.CardPersonDao;
import evg.testt.model.CardPerson;
import org.springframework.stereotype.Repository;

@Repository
public class CardPersonDaoJpaImpl extends BaseDaoJpaImpl<CardPerson> implements CardPersonDao {
}
