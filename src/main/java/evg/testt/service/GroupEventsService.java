package evg.testt.service;

import evg.testt.model.GroupEvent;

import java.util.List;

public interface GroupEventsService extends Service<GroupEvent> {
    List<GroupEvent> getAllByGroupId(Integer id);
}

