package evg.testt.dao.Jpa;

import evg.testt.model.RegisteredUser;
import evg.testt.model.Student;
import evg.testt.dao.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentRepositoryJpaImpl extends RegisteredUserRepositoryJpaImpl<Student> implements StudentRepository {
    @Override
    public List<Student> findStudensByTeacher(int teacher_id) {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student WHERE student.teacher.id = :id AND student.person.state = 'ACTIVE'", Student.class);

        query.setParameter("id", teacher_id);

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsWithoutTeacher() {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.teacher.id is null AND student.person.state = 'ACTIVE'", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentsByGroup(int group_id) {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.group.id = :id AND student.person.state = 'ACTIVE'", Student.class);

        query.setParameter("id", group_id);

        return query.getResultList();
    }

    @Override
    public List<Student> findStudentWithoutGroup() {
        TypedQuery<Student> query = em.createQuery("SELECT student FROM students student where student.group.id is null AND student.person.state = 'ACTIVE'", Student.class);

        return query.getResultList();
    }
}
