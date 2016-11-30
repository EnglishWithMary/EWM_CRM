package evg.testt.service.impl;

import evg.testt.model.Activity;
import evg.testt.dao.ActivityRepository;
import evg.testt.service.ActivityService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ActivityServiceImpl extends BaseService<Activity, ActivityRepository> implements ActivityService {

    @Override
    public void insertActivity(Activity activity) throws SQLException {
        dao.saveActivity(activity);
    }
}