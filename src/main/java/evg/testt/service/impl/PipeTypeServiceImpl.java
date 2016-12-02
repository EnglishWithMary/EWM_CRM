package evg.testt.service.impl;

import evg.testt.model.Pipe;
import evg.testt.model.PipeType;
import evg.testt.dao.PipeTypeRepository;
import evg.testt.service.PipeTypeService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PipeTypeServiceImpl extends BaseService<PipeType, PipeTypeRepository> implements PipeTypeService {

    @Override
    public PipeType getPipe(Pipe pipe) throws SQLException{

        return dao.findPipe(pipe);
    }
}