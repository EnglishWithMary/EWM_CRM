package evg.testt.repository;

import evg.testt.model.Student;

import java.util.Collection;

public interface StudentRepository {

    Collection<Student> getAll();

    Student findById(Integer id);

    void save(Student student);
}
