package evg.testt.repository.Jpa;

import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Student> implements StudentRepository {

    @Override
    public List<Student> findSortedByRegistrationDate() throws SQLException {

        Query query = em.createQuery("select s from students s join s.person p order by p.registrationDate asc");
        List<Student> result = (List<Student>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;
    }
}
