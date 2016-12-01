package evg.testt.service;


import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.model.PipeType;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

public interface CardService extends Service<Card>{
    List<Card> getCards(Pipe pipe) throws SQLException;
}
