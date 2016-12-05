package evg.testt.dao;

import evg.testt.model.Student;

import java.util.List;

public interface StudentRepository extends HumanRepository<Student>{
    List<Student> findStudensByTeacher(int teacher_id);
    List<Student> findStudentsWithoutTeacher();
    List<Student> findStudentsByGroup(int group_id);
    List<Student> findStudentWithoutGroup();

}
