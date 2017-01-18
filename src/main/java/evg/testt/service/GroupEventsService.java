package evg.testt.service;

import evg.testt.model.GroupEvent;

import java.sql.Date;
import java.util.List;

public interface GroupEventsService extends Service<GroupEvent> {
    List<GroupEvent> getAllByGroupId(Integer id);
    List<GroupEvent> getAllByDate(Date start, Date end);
}

