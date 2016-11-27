package evg.testt.dao;

import evg.testt.model.Manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerDao extends BaseDao<Manager> {

    List<Manager> findSortedByRegistrationDate() throws SQLException;

    List<Manager> findByPageSorted(int pageNumber) throws SQLException;
}
