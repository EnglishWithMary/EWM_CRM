package evg.testt.repository.Jpa;

import evg.testt.model.Package;
import evg.testt.repository.PackageRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class PackageRepositoryJpaImpl implements PackageRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Package> getAll() {
        Query query = em.createQuery("SELECT package FROM packages package");
        return query.getResultList();
    }

    @Override
    public Package findById(Integer id) {
        Query query = em.createQuery("SELECT package FROM packages package WHERE admin.id =:id");
        query.setParameter("id", id);
        return (Package) query.getSingleResult();
    }

    @Override
    public void save(Package p) {
        if(p.getId() == null){
            em.persist(p);
        } else {
            em.merge(p);
        }
    }
}
