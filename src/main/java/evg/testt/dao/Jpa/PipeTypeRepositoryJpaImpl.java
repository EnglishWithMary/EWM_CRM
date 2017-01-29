package evg.testt.dao.Jpa;

import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
import evg.testt.dao.PipeTypeRepository;
import evg.testt.service.PipeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class PipeTypeRepositoryJpaImpl
        extends BaseRepositoryJpaImpl<PipeType>
        implements PipeTypeRepository {

    @Override
    public PipeType findPipe(Pipe pipe) throws SQLException {
        PipeType pt = this.findOne(pipe.getPipeId());
        return pt;
    }
}
