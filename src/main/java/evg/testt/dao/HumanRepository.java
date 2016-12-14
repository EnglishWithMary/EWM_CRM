package evg.testt.dao;

import evg.testt.model.Human;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public interface HumanRepository<T extends  Human> extends BaseRepository<T>{

    Collection<T> findAll();

    List<T> findSortedByRegistrationDate() throws SQLException;

    List<T> findByPageSorted(int pageNumber) throws SQLException;

    List<T> findByPage(int pageNumber);
}