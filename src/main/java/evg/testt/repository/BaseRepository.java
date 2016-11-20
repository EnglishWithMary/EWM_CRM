package evg.testt.repository;

import evg.testt.model.BaseModel;

import java.util.Collection;

public interface BaseRepository <T extends BaseModel> {

    Collection<T> getAll();

    T findById(Integer id);

    void save(T t);
}
