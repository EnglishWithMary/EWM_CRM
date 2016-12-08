package evg.testt.dao;

import evg.testt.model.BaseModel;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface BaseRepository <T extends BaseModel> {

    Collection<T> findAll();

    T findOne(Integer id);

    void save(T t);

    void delete(T t);

    boolean exists(Integer id);

    int count();

    List<T> findByPage(int page);

    List<T> findSortedByRegistrationDate() throws SQLException;

    List<T> findByPageSorted(int pageNumber) throws SQLException;

}
