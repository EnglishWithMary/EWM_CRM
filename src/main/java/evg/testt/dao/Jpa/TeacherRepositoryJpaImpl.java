package evg.testt.dao.Jpa;

import evg.testt.model.Group;
import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherRepositoryJpaImpl extends RegisteredUserRepositoryJpaImpl<Teacher> implements TeacherRepository {

    public List<Teacher> findTeacherByLevel(int teacherLevel) {

        Query query = em.createQuery("SELECT teacher FROM teachers teacher WHERE level =:teacherLevel");
        query.setParameter("teacherLevel", teacherLevel);
        List<Teacher> result = (List<Teacher>) query.getResultList();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }


    }

}
