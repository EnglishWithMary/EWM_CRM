package evg.testt.repository.Jpa;

import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Student> implements StudentRepository {
}
