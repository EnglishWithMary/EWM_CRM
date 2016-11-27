package evg.testt.dao;

import evg.testt.model.Student;

import java.util.List;

import java.sql.SQLException;

public interface StudentDao extends BaseDao<Student> {
    List<Student> findStudensByTeacher(int teacher_id);
    List<Student> findStudentsWithoutTeacher();
    List<Student> findSortedByRegistrationDate() throws SQLException;
}
