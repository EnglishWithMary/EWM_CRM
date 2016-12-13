package evg.testt.service;

import evg.testt.model.Student;

import java.util.Collection;
import java.util.List;

import java.sql.SQLException;
import java.util.List;

public interface StudentService extends RegisteredUserService<Student> {
    List<Student> getAllByTeacher(int teacher_id);
    List<Student> getStudentsWithoutTeacher();
    List<Student> getAllByGroup(int group_id);
    List<Student> getStudentsWithoutGroup();
    List<Student> getAllStudentsWithGroup() throws SQLException;
}
