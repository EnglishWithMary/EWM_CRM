package evg.testt.repository.Jpa;

import evg.testt.model.BaseModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public abstract class BaseRepositoryJpaImpl<T extends BaseModel> {

    @PersistenceContext
    EntityManager em;

    public Collection<T> getAll() {
        Query query = em.createQuery("SELECT T FROM T" + "s" + " T");
        return query.getResultList();
    }

    public T findById(Integer id) {
        Query query = em.createQuery("SELECT T FROM T" + "s" + " T WHERE T.id =:id");
        query.setParameter("id", id);
        Collection<T> result = query.getResultList();
        if (result.size() > 0) {
            return (T)result.toArray()[0];
        }else {
            return null;
        }
    }

    public void save(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            em.merge(t);
        }
    }
}
