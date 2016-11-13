package evg.testt.repository.Jpa;

import evg.testt.model.Manager;
import evg.testt.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class ManagerRepositoryJpaImpl implements ManagerRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Manager> getAll() {
        Query query = em.createQuery("SELECT manager FROM managers manager LEFT JOIN FETCH " +
                "manager.person");
        return query.getResultList();
    }

    @Override
    public Manager findById(Integer id) {
        Query query = em.createQuery("SELECT manager FROM managers manager LEFT JOIN FETCH " +
                "manager.person WHERE manager.id =:id");
        query.setParameter("id", id);
        return (Manager) query.getSingleResult();
    }

    @Override
    public void save(Manager manager) {
        if(manager.getId() == null){
            em.persist(manager);
        } else {
            em.merge(manager);
        }
    }
}
