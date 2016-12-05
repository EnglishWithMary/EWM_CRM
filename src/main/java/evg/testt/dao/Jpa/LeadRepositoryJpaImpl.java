package evg.testt.dao.Jpa;

import evg.testt.model.Lead;
import evg.testt.model.Person;
import evg.testt.dao.LeadRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeadRepositoryJpaImpl extends BaseRepositoryJpaImpl<Lead> implements LeadRepository {

    @Override
    public Lead findByPerson(Person person) {
        Query query = em.createQuery("SELECT l FROM leads l WHERE l.person =:p");
        query.setParameter("p", person);
        List<Lead> result = ( List<Lead>) query.getResultList();
        if (result.size()>0)
            return (Lead)result.get(0);
        else return null;
    }
}
