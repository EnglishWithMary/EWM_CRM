package evg.testt.service;

import evg.testt.model.Student;

import java.util.List;

public interface StudentService extends Service<Student> {
    List<Student> getAllByTeacher(int teacher_id);
    List<Student> getStudentsWithoutTeacher();

}
