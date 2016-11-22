package evg.testt.repository.Jpa;

import evg.testt.model.BaseModel;
import evg.testt.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

@Transactional
@Repository
@PropertySource(value = "classpath:standard.properties")
public abstract class BaseRepositoryJpaImpl<T extends BaseModel> implements BaseRepository<T>{

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager em;

    @Value("${pagination.page.size}")
    protected int pageSize;

    public BaseRepositoryJpaImpl(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public Collection<T> findAll() {

        Query query = em.createQuery("SELECT t FROM " + entityClass.getName() + " t");
        return (List<T>)query.getResultList();

    }

    public T findOne(Integer id) {
//        Query query = em.createQuery("SELECT T FROM T" + "s" + " T WHERE T.id =:id");
//        query.setParameter("id", id);
//        Collection<T> result = query.getResultList();

        return em.find(entityClass, id);

//        if (result.size() > 0) {
//            return (T)result.toArray()[0];
//        }else {
//            return null;
//        }
    }

    public void save(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            em.merge(t);
        }
    }

    public void delete(T t){
        em.remove(t);
    }

    public boolean exists(Integer id){
        return findOne(id) == null;
    }

    public int count()
    {
        long total = 0;
        Query query = em.createQuery("SELECT count(t) FROM " + entityClass.getName() + " t");
        total = (long)query.getSingleResult();
        return (int)total;
    }

    public List<T> findByPage(int pageNumber)
    {
        Query query = em.createQuery("SELECT t FROM " + entityClass.getName() + " t");
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
