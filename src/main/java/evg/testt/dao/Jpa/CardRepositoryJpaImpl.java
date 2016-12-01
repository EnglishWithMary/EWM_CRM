package evg.testt.dao.Jpa;

import evg.testt.model.Card;
import evg.testt.model.Person;
import evg.testt.model.PipeType;
import evg.testt.dao.CardRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CardRepositoryJpaImpl extends BaseRepositoryJpaImpl<Card> implements CardRepository {

    @Override
    public List<Card> findCards(PipeType pipe) throws SQLException {
        List<Card> cards;
        Query query = em.createQuery("select distinct card from cards card left join fetch card.persons " +
                "where card.type = :pipe order by card.id ASC");
        query.setParameter("pipe", pipe);
        cards = query.getResultList();
        return cards;
    }
}
