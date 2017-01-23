package evg.testt.dao.Jpa;

import evg.testt.exception.PersonFieldTypeNotFoundException;
import evg.testt.model.BaseModel;
import evg.testt.model.Person;
import evg.testt.dao.BaseRepository;
import evg.testt.model.StateType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
@PropertySource(value = "classpath:standard.properties")
public abstract class BaseRepositoryJpaImpl<T extends BaseModel>
        implements BaseRepository<T> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager em;

    @Value("${pagination.page.size}")
    protected int pageSize;

    public BaseRepositoryJpaImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public Collection<T> findAll() {
        Query query = em.createQuery("SELECT t FROM " + entityClass.getName() + " t");
        return (List<T>) query.getResultList();
    }

    public T findOne(Integer id) {
        return em.find(entityClass, id);
    }

    public void save(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            em.merge(t);
        }
    }

    public void delete(T t) {
        em.remove(t);
    }

    public boolean exists(Integer id) {
        return findOne(id) != null;
    }

    public int count() {
        long count;
        Query query = em.createQuery("SELECT count(t) FROM " + entityClass.getName() + " t");
        count = (long) query.getSingleResult();
        return (int) count;
    }

    public List<T> findByPage(int pageNumber) {
        Query query = em.createQuery("SELECT t FROM " + entityClass.getName() + " t");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return (List<T>) query.getResultList();
    }

    public Query findPaginated(int pageNumber) {
        Query query = em.createQuery("SELECT t FROM " + entityClass.getName() + " t");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query;
    }

    /*
        Here should be sorting parameters
     */
    public List<T> findAllSortedAndPaginated(int pageNumber) {
        return findPaginated(pageNumber).getResultList();
    }

    private Boolean hasPerson() {
        Boolean hasPerson = false;
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType().equals(Person.class)) {
                hasPerson = true;
                break;
            }
        }
        return hasPerson;
    }

    @Override
    public List<T> findByPageSorted(int pageNumber) throws SQLException {
        if (!hasPerson()) throw new PersonFieldTypeNotFoundException(entityClass.getName() +
                " has no field of " + Person.class.getName() + " type.");
        Query query = em.createQuery("select t from " + entityClass.getName() +
                " t join t.person p order by p.registrationDate asc");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

}