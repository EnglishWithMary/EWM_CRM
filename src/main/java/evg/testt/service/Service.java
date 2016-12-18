package evg.testt.service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Transactional
public interface Service<T> {

    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void delete(T o) throws SQLException;

    void insert(T o) throws SQLException;

    void update(T o) throws SQLException;

    boolean isExists(Integer id) throws SQLException;

    int count() throws SQLException;

    List<T> getByPage(int pageNumber);

    List<T> getByPageSorted(int pageNumber) throws SQLException;

    List<T> getAllSortedAndPaginated(int pageNumber)throws SQLException;
}
