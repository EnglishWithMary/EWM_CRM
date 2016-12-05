package evg.testt.dao;

import evg.testt.model.Card;
import evg.testt.model.Person;
import evg.testt.model.Pipe;
import evg.testt.model.PipeType;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

public interface CardRepository extends BaseRepository<Card> {

    List<Card> findCards(PipeType pipe) throws SQLException;

    Card findCardByPerson(Person person) throws SQLException;
}
