package evg.testt.dao.Jpa;

import evg.testt.dao.GroupDao;
import evg.testt.model.Group;
import evg.testt.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class GroupDaoJpaImpl extends BaseDaoJpaImpl<Group> implements GroupDao {

    @Override
    public List<Group> findByTeacher(Teacher teacher) {
        Query query = em.createQuery("SELECT group FROM groups group WHERE group.teacher =:teacher");
        query.setParameter("teacher", teacher);
        List<Group> result = (List<Group>) query.getResultList();
        if(result.size()>0) {
            return result;
        }else {
            return null;
        }
    }
}
