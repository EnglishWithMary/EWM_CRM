package evg.testt.dao;

import evg.testt.model.Pipe;
import evg.testt.model.PipeType;

import java.sql.SQLException;

public interface PipeTypeRepository extends BaseRepository<PipeType>{
    PipeType findPipe(Pipe pipe) throws SQLException;
}
