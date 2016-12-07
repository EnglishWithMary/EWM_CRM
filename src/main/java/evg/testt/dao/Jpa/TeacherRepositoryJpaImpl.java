package evg.testt.dao.Jpa;

import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryJpaImpl extends HumanRepositoryJpaImpl<Teacher> implements TeacherRepository {
}
