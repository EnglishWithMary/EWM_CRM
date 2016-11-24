package evg.testt.repository.Jpa;

import evg.testt.model.Lead;
import evg.testt.repository.LeadRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeadRepositoryJpaImpl extends BaseRepositoryJpaImpl<Lead> implements LeadRepository {

    @Override
    public List<Lead> findSortedByRegistrationDate() throws SQLException {
        Query query = em.createQuery("select l from leads l join l.person p order by p.registrationDate asc");
        List<Lead> result = (List<Lead>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;
    }
}
