package evg.testt.repository.Jpa;

import evg.testt.model.Person;
import evg.testt.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<Person> implements PersonRepository{

    @Override
    public List<Person> findSortedByRegistrationDate() throws SQLException {

        Query query = em.createQuery("SELECT person FROM persons person ORDER BY person.registrationDate ASC");
        List<Person> result = (List<Person>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;

    }

}
