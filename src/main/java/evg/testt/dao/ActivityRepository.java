package evg.testt.dao;

import evg.testt.dao.BaseRepository;
import evg.testt.model.Activity;

public interface ActivityRepository extends BaseRepository<Activity> {
    void saveActivity(Activity activity);
}
