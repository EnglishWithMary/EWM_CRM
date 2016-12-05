package evg.testt.service;

import evg.testt.model.Student;

import java.util.List;

import java.sql.SQLException;
import java.util.List;

public interface StudentService extends HumanService<Student> {
    List<Student> getAllByTeacher(int teacher_id);
    List<Student> getStudentsWithoutTeacher();
}
