package evg.testt.repository.Jpa;

import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
import evg.testt.model.Teacher;
import evg.testt.repository.PipeTypeRepository;
import evg.testt.repository.TeacherRepository;
import evg.testt.service.PipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class PipeTypeRepositoryJpaImpl extends BaseRepositoryJpaImpl<PipeType> implements PipeTypeRepository {
    @Autowired
    private PipeTypeService pts;

    @Override
    public PipeType findPipe(Pipe pipe) throws SQLException {
        PipeType pt = new PipeType();
        pt = pts.getById(pipe.getPipeId());
        return pt;
    }
}
