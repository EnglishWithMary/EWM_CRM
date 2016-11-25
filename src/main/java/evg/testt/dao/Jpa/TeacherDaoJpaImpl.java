package evg.testt.dao.Jpa;

import evg.testt.dao.TeacherDao;
import evg.testt.model.Teacher;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherDaoJpaImpl extends BaseDaoJpaImpl<Teacher> implements TeacherDao {

    @Override
    public List<Teacher> findSortedByRegistrationDate() throws SQLException {
        Query query = em.createQuery("select t from teachers t join t.person p order by p.registrationDate asc");
        List<Teacher> result = (List<Teacher>) query.getResultList();
        if(result.size()>0) {
            return result;
        }
        return null;
    }
}
