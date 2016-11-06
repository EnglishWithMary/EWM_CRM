package evg.testt.service;

import evg.testt.model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService extends Service<Department>{
    public List<Department> getAllWithEmployeers() throws SQLException;
}
