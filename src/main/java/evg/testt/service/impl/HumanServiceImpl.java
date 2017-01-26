package evg.testt.service.impl;

import evg.testt.dao.HumanRepository;
import evg.testt.dto.PersonDTO;
import evg.testt.model.Card;
import evg.testt.model.Human;
import evg.testt.model.Person;
import evg.testt.service.CardService;
import evg.testt.service.HumanService;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public abstract class HumanServiceImpl<T extends Human, P extends HumanRepository<T>>
        extends BaseService<T, P> implements HumanService<T> {

    @Autowired
    CardService cardService;
    @Autowired
    PersonService personService;

    @Override
    public void delete(T o) throws SQLException {
        o.getPerson().getState().setState("DELETED");
        dao.save(o);
    }

    public void trash(T o) throws SQLException {
        o.getPerson().getState().setState("TRASHED");
        dao.save(o);
    }

    public void restore(T o) throws SQLException {
        o.getPerson().getState().setState("ACTIVE");
        dao.save(o);
    }

    public List<T> getSortedByRegistrationDate() throws SQLException {
        return dao.findSortedByRegistrationDate();
    }

    public List<T> getByPageSorted(int pageNumber) throws SQLException {
        return dao.findByPageSorted(pageNumber);
    }

    public void updatePosition(T human, PersonDTO personDTO) throws SQLException {

        Person person = human.getPerson();
        Card newCard, oldCard;

//      Replace Person From old Card To New Card
        oldCard = cardService.getCardByPerson(person);

        if (oldCard != null) {
            if (!personDTO.getCardId().equals(oldCard.getId())) {

                oldCard.getPersons().remove(person);

                cardService.update(oldCard);
            }
        }

        newCard = cardService.getById(personDTO.getCardId());

        newCard.getPersons().add(person);

        cardService.update(newCard);

        person.setPosition(0);

        personService.update(person);
    }
}