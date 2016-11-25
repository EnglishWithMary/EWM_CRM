package evg.testt.service.impl;

import evg.testt.dao.CardDao;
import evg.testt.dao.PipeTypeDao;
import evg.testt.model.Card;
import evg.testt.service.CardService;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl extends BaseService<Card, CardDao> implements CardService {

}