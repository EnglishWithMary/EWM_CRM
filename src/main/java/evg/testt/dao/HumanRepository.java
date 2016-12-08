package evg.testt.dao;

import evg.testt.model.Human;

import java.sql.SQLException;
import java.util.Collection;


public interface HumanRepository<T extends  Human> extends BaseRepository<T>{

    Collection<T> findAll();

}
