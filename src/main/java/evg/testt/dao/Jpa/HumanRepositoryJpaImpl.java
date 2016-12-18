package evg.testt.dao.Jpa;


import evg.testt.dao.HumanRepository;
import evg.testt.model.Human;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public abstract class HumanRepositoryJpaImpl<T extends Human> extends BaseRepositoryJpaImpl<T>
        implements HumanRepository<T>{

    private String query = "SELECT l FROM " + entityClass.getName() +
            " l JOIN l.person p WHERE p.state = 'ACTIVE'";

    @Override
    public Collection<T> findAll() {

        Query query = em.createQuery(this.query);

        return (List<T>)query.getResultList();
    }

    public List<T> findByPage(int pageNumber) {

        Query query = em.createQuery(this.query);

        query.setFirstResult((pageNumber-1) * pageSize);

        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    public List<T> findSortedByRegistrationDate() throws SQLException {
        Query query = em.createQuery(this.query + " order by p.registrationDate asc");

        return query.getResultList();
    }

    public List<T> findByPageSorted(int pageNumber) throws SQLException {
        Query query = em.createQuery(this.query + " order by p.registrationDate asc");

        query.setFirstResult((pageNumber-1) * pageSize);

        query.setMaxResults(pageSize);

        return query.getResultList();
    }
}
