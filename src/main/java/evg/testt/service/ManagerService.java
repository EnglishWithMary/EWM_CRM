package evg.testt.service;

import evg.testt.model.Manager;

import java.sql.SQLException;
import java.util.List;

public interface ManagerService extends Service<Manager> {
    List<Manager> getSortedByRegistrationDate() throws SQLException;

    List<Manager> getByPageSorted(int pageNumber)throws SQLException;
}
