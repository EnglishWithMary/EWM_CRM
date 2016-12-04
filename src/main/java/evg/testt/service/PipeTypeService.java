package evg.testt.service;


import evg.testt.model.Pipe;
import evg.testt.model.PipeType;

import java.sql.SQLException;

public interface PipeTypeService extends Service<PipeType>{
    PipeType getPipe(Pipe pipe) throws SQLException;
}
