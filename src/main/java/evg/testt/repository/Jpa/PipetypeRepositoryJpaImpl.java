package evg.testt.repository.Jpa;

import evg.testt.model.PipeType;
import evg.testt.model.Teacher;
import evg.testt.repository.PipeTypeRepository;
import evg.testt.repository.TeacherRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PipetypeRepositoryJpaImpl extends BaseRepositoryJpaImpl<PipeType> implements PipeTypeRepository {
}
