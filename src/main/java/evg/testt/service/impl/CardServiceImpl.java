package evg.testt.service.impl;

import evg.testt.dao.PipeTypeRepository;
import evg.testt.model.Card;
import evg.testt.model.Person;
import evg.testt.model.Pipe;
import evg.testt.dao.CardRepository;
import evg.testt.model.PipeType;
import evg.testt.service.CardService;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class CardServiceImpl extends BaseService<Card, CardRepository> implements CardService {

    @Autowired
    PipeTypeRepository pr;

    @Autowired
    PersonService personService;

    @Override
    public List<Card> getCards(Pipe pipe) throws SQLException {
        PipeType pipeType = pr.findPipe(pipe);
        return dao.findCards(pipeType);
    }

    @Override
    public void movePersonOnCards(int from, int destination, int personId) throws SQLException {
        Person movingPerson = personService.getById(personId);
        dao.movePersonOnCards(from, destination, movingPerson);
    }

    @Override
    @Transactional
    public Card getCardByPerson(Person person) throws SQLException {
        return dao.findCardByPerson(person);
    }

    @Override
    @Transactional
    public void delete(Card card) throws SQLException{
        dao.delete(dao.findOne(card.getId()));
    }

    @Override
    @Transactional
    public Card getCardByPerson(Person person) throws SQLException {
        return dao.findCardByPerson(person);
    }
}