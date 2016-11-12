package evg.testt.repository.Jpa;

import evg.testt.model.Admin;
import evg.testt.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class AdminRepositoryJpaImpl implements AdminRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Admin> getAll() {
        Query query = em.createQuery("SELECT admin FROM admins admin LEFT JOIN FETCH " +
                "admin.person");
        return query.getResultList();
    }

    @Override
    public Admin findById(Integer id) {
        Query query = em.createQuery("SELECT admin FROM Admin admin LEFT JOIN FETCH " +
                "admin.person WHERE admin.id =: id");
        query.setParameter("id", id);
        return (Admin) query.getSingleResult();
    }

    @Override
    public void save(Admin admin) {
        if(admin.getId() == null){
            em.persist(admin);
        } else {
            em.merge(admin);
        }
    }
}
