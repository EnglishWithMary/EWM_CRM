package evg.testt.repository;

import evg.testt.model.Activity;

public interface ActivityRepository extends BaseRepository<Activity> {
    void saveActivity(Activity activity);
}
