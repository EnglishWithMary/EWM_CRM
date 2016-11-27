package evg.testt.dao.Jpa;

import evg.testt.model.Activity;
import evg.testt.dao.ActivityRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ActivityRepositoryJpaImpl extends BaseRepositoryJpaImpl<Activity> implements ActivityRepository{
    @Override
    public void saveActivity(Activity activity) {
        if(activity.getId() == null)
        {
            em.persist(activity);
        }
        else
        {
            em.merge(activity);
        }
    }
}
