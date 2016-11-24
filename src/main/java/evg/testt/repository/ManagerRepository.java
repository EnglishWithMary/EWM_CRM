package evg.testt.repository;

import evg.testt.model.Manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerRepository extends BaseRepository<Manager>{

    List<Manager> findSortedByRegistrationDate() throws SQLException;

    List<Manager> findByPageSorted(int pageNumber) throws SQLException;
}
