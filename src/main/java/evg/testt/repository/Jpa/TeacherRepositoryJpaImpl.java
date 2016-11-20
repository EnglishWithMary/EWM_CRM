package evg.testt.repository.Jpa;

import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryJpaImpl extends BaseRepositoryJpaImpl<Teacher> implements TeacherRepository {
}
