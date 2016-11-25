package evg.testt.repository.Jpa;

import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TeacherRepositoryJpaImpl extends BaseRepositoryJpaImpl<Teacher> implements TeacherRepository {
}
