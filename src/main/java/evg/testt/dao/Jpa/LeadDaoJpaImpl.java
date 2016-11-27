package evg.testt.dao.Jpa;

import evg.testt.dao.LeadDao;
import evg.testt.model.Lead;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeadDaoJpaImpl extends BaseDaoJpaImpl<Lead> implements LeadDao {

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
