package evg.testt.repository;

import evg.testt.model.Student;

import java.util.List;

public interface StudentRepository extends BaseRepository<Student>{
    List<Student> findStudensByTeacher(int teacher_id);
    List<Student> findStudentsWithoutTeacher();
}
