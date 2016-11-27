package evg.testt.service.impl;

import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.dao.CardRepository;
import evg.testt.service.CardService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class CardServiceImpl extends BaseService<Card, CardRepository> implements CardService {

    @Override
    public List<Card> getCards(Principal principal, Pipe pipe) throws Exception {
        return dao.findCards(principal, pipe);
    }
}