package evg.testt.repository.Jpa;

import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class StudentRepositoryJpaImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Student> getAll() {
        Query query = em.createQuery("SELECT student FROM students student LEFT JOIN FETCH " +
                "student.person");
        return query.getResultList();
    }

    @Override
    public Student findById(Integer id) {
        Query query = em.createQuery("SELECT student FROM students student LEFT JOIN FETCH " +
                "student.person WHERE student.id =:id");
        query.setParameter("id", id);
        return (Student) query.getSingleResult();
    }

    @Override
    public void save(Student student) {
        if(student.getId() == null){
            em.persist(student);
        } else {
            em.merge(student);
        }
    }
}
