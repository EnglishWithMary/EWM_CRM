package evg.testt.dao.Jpa;

import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
import evg.testt.model.User;
import evg.testt.dao.CardRepository;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class CardRepositoryJpaImpl extends BaseRepositoryJpaImpl<Card> implements CardRepository {

    @Override
    public List<Card> findCards(PipeType pipe) throws SQLException {
        List<Card> cards = Collections.EMPTY_LIST;
        Query query = em.createQuery("select card from cards card left join fetch card.persons " +
                "where card.type = :pipe order by card.id ASC");
        query.setParameter("pipe", pipe);
        cards = query.getResultList();
        return cards;
    }
}
