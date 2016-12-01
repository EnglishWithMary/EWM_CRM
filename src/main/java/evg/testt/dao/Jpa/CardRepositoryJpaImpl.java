package evg.testt.dao.Jpa;

import evg.testt.model.Card;
import evg.testt.model.Pipe;
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

    @Autowired
    private UserService us;

    @Override
    public List<Card> findCards(Principal principal, Pipe pipe) throws SQLException {
        List<Card> cards = Collections.EMPTY_LIST;

        User user = us.findByUserLogin(principal.getName());

        Query query = em.createQuery("from cards where type_id = :tid order by id ASC");
        query.setParameter("tid", pipe.getPipeId());
        cards = query.getResultList();

        return cards;
    }
}
