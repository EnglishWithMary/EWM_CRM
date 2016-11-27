package evg.testt.dao;

import evg.testt.model.BaseModel;

import java.util.Collection;
import java.util.List;

public interface BaseDao<T extends BaseModel> {

    Collection<T> findAll();

    T findOne(Integer id);

    void save(T t);

    void delete(T t);

    boolean exists(Integer id);

    int count();

    List<T> findByPage(int page);
}
