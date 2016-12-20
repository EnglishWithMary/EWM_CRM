package evg.testt.service.impl;

import evg.testt.dao.GroupEventsRepository;
import evg.testt.model.GroupEvent;
import evg.testt.service.GroupEventsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupEventsServiceImpl extends BaseService<GroupEvent, GroupEventsRepository>
        implements GroupEventsService{


    @Override
    public List<GroupEvent> getAllByGroupId(Integer id) {
        return dao.findAllByGroupId(id);
    }
}



