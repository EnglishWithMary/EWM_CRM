package evg.testt.repository;

import evg.testt.model.Teacher;

import java.util.Collection;

public interface TeacherRepository {

    Collection<Teacher> getAll();

    Teacher findById(Integer id);

    void save(Teacher teacher);
}
