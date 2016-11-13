package evg.testt.repository.Jpa;

import evg.testt.model.Role;
import evg.testt.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class RoleRepositoryJpaImpl implements RoleRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Role> getAll() {
        Query query = em.createQuery("SELECT role FROM roles role");
        return query.getResultList();
    }

    @Override
    public Role findById(Integer id) {
        Query query = em.createQuery("SELECT role FROM roles role WHERE role.id =:id");
        query.setParameter("id", id);
        return (Role) query.getSingleResult();
    }

    @Override
    public void save(Role role) {
        if(role.getId() == null){
            em.persist(role);
        } else {
            em.merge(role);
        }
    }
}
