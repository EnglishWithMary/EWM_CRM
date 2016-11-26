package evg.testt.service.impl;

import evg.testt.dao.CardDao;
import evg.testt.dao.PipeTypeDao;
import evg.testt.model.Card;
import evg.testt.model.PipeType;
import evg.testt.repository.CardRepository;
import evg.testt.service.CardService;
import evg.testt.service.PipeTypeService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends BaseService<Card, CardRepository> implements CardService {

}