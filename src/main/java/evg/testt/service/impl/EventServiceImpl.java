package evg.testt.service.impl;

import evg.testt.dao.EventDao;
import evg.testt.model.Event;
import evg.testt.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl extends BaseService<Event, EventDao> implements EventService {

}