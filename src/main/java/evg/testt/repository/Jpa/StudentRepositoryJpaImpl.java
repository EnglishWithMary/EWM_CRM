package evg.testt.repository.Jpa;

import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import javax.persistence.Query;
import java.sql.SQLException;

@Repository
public class StudentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Student> implements StudentRepository {
    @Override
    public List<Student> findStudensByTeacher(int teacher_id) {
        List<Student> students = Collections.EMPTY_LIST;
            TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.teacher.id = :id", Student.class);
            query.setParameter("id", teacher_id);
            students = query.getResultList();
        return students;
    }

    @Override
    public List<Student> findStudentsWithoutTeacher() {
        List<Student> students = Collections.EMPTY_LIST;
            TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.teacher.id is null", Student.class);
            students = query.getResultList();
        return students;
    }

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
