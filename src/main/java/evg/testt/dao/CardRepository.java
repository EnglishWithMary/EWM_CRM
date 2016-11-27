package evg.testt.dao;

import evg.testt.model.Card;
import evg.testt.model.Pipe;

import java.security.Principal;
import java.util.List;

public interface CardRepository extends BaseRepository<Card> {

    List<Card> findCards(Principal principal, Pipe pipe) throws Exception;

}
