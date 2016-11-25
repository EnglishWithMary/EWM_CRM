package evg.testt.service.impl;

import evg.testt.model.BaseModel;
import evg.testt.repository.BaseRepository;
import evg.testt.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseService <T extends BaseModel, P extends BaseRepository<T>> implements Service<T> {

    protected  P dao;

    @Autowired
    public void setPersistence(P dao){
        this.dao = dao;
    }

    public List<T> getAll() throws SQLException {
        return (List<T>)(dao.findAll());
    }

    public T getById(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    public void delete(T o) throws SQLException {
        dao.delete(o);
    }

     public void insert(T o) throws SQLException {
        dao.save(o);
    }

    public void update(T o) throws SQLException {
        dao.save(o);
    }

    public boolean isExists(Integer id) throws SQLException {
        return dao.exists(id);
    }

    public int count()
    {
       return dao.count();
    }

    public List<T> getByPage(int pageNumber)
    {
        return dao.findByPage(pageNumber);
    }

    public List<T> getSortedByRegistrationDate() throws SQLException{
        return dao.findSortedByRegistrationDate();
    }
    public List<T> getByPageSorted(int pageNumber) throws SQLException{
        return dao.findByPageSorted(pageNumber);
    }
}
