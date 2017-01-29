package evg.testt.dao.Jpa;

import evg.testt.ajax.utils.AjaxFormCall;
import evg.testt.ajax.utils.PersonPositions;
import evg.testt.model.*;
import evg.testt.dao.CardRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CardRepositoryJpaImpl extends BaseRepositoryJpaImpl<Card> implements CardRepository {

    @Override
    public List<Card> findCards(PipeType pipe) throws SQLException {
        List<Card> cards;
        Query query = em.createQuery("select distinct card from cards card " +
                "left join fetch card.persons " +
                "where card.type = :pipe order by card.id ASC");
        query.setParameter("pipe", pipe);
        cards = query.getResultList();
        return cards;
    }

    @Override
    public Card findCardByPerson(Person person) throws SQLException {
        Query query = em.createQuery("SELECT c FROM cards c join c.persons p"+
                " WHERE p =:person");
        query.setParameter("person", person);
        List<Card> result = ( List<Card>) query.getResultList();
        if (result.size()>0)
            return (Card) result.get(0);
        else return null;
    }

    @Override
    public void movePersonOnCards(AjaxFormCall ajaxFormCall, Person person) throws SQLException {
        Card sourceCard = findOne(ajaxFormCall.getFrom());
        Card destinationCard = findOne(ajaxFormCall.getDestination());

        if(ajaxFormCall.getFrom() != ajaxFormCall.getDestination()){
            sourceCard.getPersons().remove(person);
            destinationCard.getPersons().add(person);
        }

        for (PersonPositions positions : ajaxFormCall.getArray()) {
            for (Person cardPerson : destinationCard.getPersons()) {
                if(cardPerson.getId() == positions.getId())
                    cardPerson.setPosition(positions.getPosition());
            }
        }

        save(sourceCard);
        save(destinationCard);

    }
}
