package evg.testt.service.impl;

import evg.testt.dao.BaseRepository;
import evg.testt.dao.HumanRepository;
import evg.testt.dao.Jpa.BaseRepositoryJpaImpl;
import evg.testt.model.BaseModel;
import evg.testt.model.Human;
import evg.testt.model.Manager;
import evg.testt.service.HumanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public abstract
class HumanServiceImpl <T extends Human, P extends HumanRepository<T>>
        extends BaseService<T, P> implements HumanService<T>{

    @Override
    public void delete (T o) throws SQLException{
        o.getPerson().getState().setState("DELETED");
        dao.save(o);
    }

    public void trash (T o) throws SQLException{
        o.getPerson().getState().setState("TRASHED");
        dao.save(o);
    }

    public void restore (T o) throws SQLException{
        o.getPerson().getState().setState("ACTIVE");
        dao.save(o);
    }

    @Override
    public List<T> getAll() throws SQLException {
        return (List<T>)(dao.findAll());
    }
}