package evg.testt.repository;

import evg.testt.model.Pipe;
import evg.testt.model.PipeType;

public interface PipeTypeRepository extends BaseRepository<PipeType>{
    PipeType findPipe(Pipe pipe) throws Exception;
}
