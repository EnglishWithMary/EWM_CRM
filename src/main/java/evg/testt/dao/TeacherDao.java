package evg.testt.dao;

import evg.testt.model.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao extends BaseDao<Teacher> {
    List<Teacher> findSortedByRegistrationDate() throws SQLException;
}
