package evg.testt.repository;

import evg.testt.model.BaseModel;

import java.util.Collection;

public interface BaseRepository <T extends BaseModel> {

    Collection<T> findAll();

    T findOne(Integer id);

    void save(T t);

    void delete(T t);

    boolean exists(Integer id);
}
