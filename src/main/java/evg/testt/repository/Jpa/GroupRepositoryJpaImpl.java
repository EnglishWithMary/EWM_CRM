package evg.testt.repository.Jpa;

import evg.testt.model.Group;
import evg.testt.repository.GroupRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class GroupRepositoryJpaImpl implements GroupRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Group> getAll() {
        Query query = em.createQuery("SELECT group FROM groups group");
        return query.getResultList();
    }

    @Override
    public Group findById(Integer id) {
        Query query = em.createQuery("SELECT group FROM groups group WHERE group.id =:id");
        query.setParameter("id", id);
        return (Group) query.getSingleResult();
    }

    @Override
    public void save(Group group) {
        if(group.getId() == null){
            em.persist(group);
        } else {
            em.merge(group);
        }
    }
}
