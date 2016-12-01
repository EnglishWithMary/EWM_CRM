package evg.testt.service.impl;

import evg.testt.dao.PipeTypeRepository;
import evg.testt.model.Card;
import evg.testt.model.Pipe;
import evg.testt.dao.CardRepository;
import evg.testt.model.PipeType;
import evg.testt.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

@Service
public class CardServiceImpl extends BaseService<Card, CardRepository> implements CardService {

    @Autowired
    PipeTypeRepository pr;

    @Override
    public List<Card> getCards(Pipe pipe) throws SQLException {
        PipeType pipeType = pr.findPipe(pipe);
        return dao.findCards(pipeType);
    }
}