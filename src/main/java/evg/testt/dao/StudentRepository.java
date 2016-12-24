package evg.testt.dao;

import evg.testt.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository extends RegisteredUserRepository<Student>{
    List<Student> findStudensByTeacher(int teacher_id);
    List<Student> findStudentsWithoutTeacher();
    List<Student> findStudentsByGroup(int group_id);
    List<Student> findStudentsWithoutGroup();
    List<Student> findStudentsWithGroup()throws SQLException;
}
