package evg.testt.repository.Jpa;

import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class TeacherRepositoryJpaImpl implements TeacherRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Teacher> getAll() {
        Query query = em.createQuery("SELECT teacher FROM teachers teacher LEFT JOIN FETCH " +
                "teacher.person");
        return query.getResultList();
    }

    @Override
    public Teacher findById(Integer id) {
        Query query = em.createQuery("SELECT teacher FROM teachers teacher LEFT JOIN FETCH " +
                "teacher.person WHERE teacher.id =:id");
        query.setParameter("id", id);
        return (Teacher) query.getSingleResult();
    }

    @Override
    public void save(Teacher teacher) {
        if(teacher.getId() == null){
            em.persist(teacher);
        } else {
            em.merge(teacher);
        }
    }
}
