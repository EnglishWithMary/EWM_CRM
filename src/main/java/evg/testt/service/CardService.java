package evg.testt.service;


import evg.testt.model.Card;
import evg.testt.model.Pipe;

import java.security.Principal;
import java.util.List;

public interface CardService extends Service<Card>{
    List<Card> getCards(Principal principal, Pipe pipe) throws Exception;
}
