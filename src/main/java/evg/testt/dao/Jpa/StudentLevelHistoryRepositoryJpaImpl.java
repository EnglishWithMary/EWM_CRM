package evg.testt.dao.Jpa;

import evg.testt.dao.StudentLevelHistoryRepository;
import evg.testt.model.StudentLevelHistory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentLevelHistoryRepositoryJpaImpl extends BaseRepositoryJpaImpl<StudentLevelHistory> implements StudentLevelHistoryRepository {

    @Override
    public List<StudentLevelHistory> getByStudentId(Integer id) {
        Query query = em.createQuery("SELECT s FROM StudentLevelHistory s WHERE s.student.id =:id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
