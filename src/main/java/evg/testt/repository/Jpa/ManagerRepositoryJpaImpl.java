package evg.testt.repository.Jpa;

import evg.testt.model.Manager;
import evg.testt.repository.ManagerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ManagerRepositoryJpaImpl extends BaseRepositoryJpaImpl<Manager> implements ManagerRepository {
    @Override
    public List<Manager> findSortedByRegistrationDate() throws SQLException {
        Query query = em.createQuery("select t from managers t join t.person p order by p.registrationDate asc");
        List<Manager> result = (List<Manager>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;
    }

    @Override
    public List<Manager> findByPageSorted(int pageNumber) throws SQLException {
        Query query = em.createQuery("select t from managers t join t.person p order by p.registrationDate asc");
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
