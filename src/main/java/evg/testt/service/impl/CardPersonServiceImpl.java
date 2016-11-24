package evg.testt.service.impl;

import evg.testt.dao.CardPersonDao;
import evg.testt.model.CardPerson;
import evg.testt.repository.CardPersonRepository;
import evg.testt.service.CardPersonService;
import org.springframework.stereotype.Service;

@Service
public class CardPersonServiceImpl extends BaseService<CardPerson, CardPersonRepository> implements CardPersonService {

}