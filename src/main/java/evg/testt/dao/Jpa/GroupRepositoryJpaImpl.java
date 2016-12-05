package evg.testt.dao.Jpa;

import evg.testt.model.Group;
import evg.testt.model.Student;
import evg.testt.model.Teacher;
import evg.testt.dao.GroupRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class GroupRepositoryJpaImpl extends BaseRepositoryJpaImpl<Group> implements GroupRepository {

    @Override
    public List<Group> findByGroup(Group group) {
        Query query = em.createQuery("SELECT group FROM groups group WHERE group.id =:group");
        query.setParameter("group", group);
        List<Group> result = (List<Group>) query.getResultList();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }
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
