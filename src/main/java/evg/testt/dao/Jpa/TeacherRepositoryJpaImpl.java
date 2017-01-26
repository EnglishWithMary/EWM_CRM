package evg.testt.dao.Jpa;

import evg.testt.model.Student;
import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class TeacherRepositoryJpaImpl extends RegisteredUserRepositoryJpaImpl<Teacher> implements TeacherRepository {

    public Teacher findTeacherByPersonId(Integer personId){

        if (personId == null) {
            return new Teacher();
        }

        Query query = em.createQuery("SELECT teacher FROM teachers teacher WHERE teacher.person.id=:id");
        query.setParameter("id",personId);

        return (Teacher) query.getSingleResult();
    }

}
