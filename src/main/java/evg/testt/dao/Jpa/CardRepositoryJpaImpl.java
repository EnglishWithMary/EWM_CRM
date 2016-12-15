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


    @Override
    public void movePersonOnCards(int from, int destination, Person person) throws SQLException {
        Card sourceCard = findOne(from);
        Card destinationCard = findOne(destination);

        sourceCard.getPersons().remove(person);
        destinationCard.getPersons().add(person);

        save(sourceCard);
        save(destinationCard);

    }

    @Override
    public Card findCardByPerson(Person person) throws SQLException {
        Query query = em.createQuery("SELECT  c from cards c join c.persons p where p =:person");
        query.setParameter("person", person);
        List<Card> results = (List<Card>)query.getResultList();
        if (results.size()>0){
            return (Card)results.get(0);
        }else {
            return null;
        }
    }
}
