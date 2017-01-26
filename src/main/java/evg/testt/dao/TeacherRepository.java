package evg.testt.dao;

import evg.testt.model.Teacher;

import java.util.List;

public interface TeacherRepository extends RegisteredUserRepository<Teacher> {

    Teacher findTeacherByPersonId(Integer personId);

    List<Teacher> findTeacherByLevel(int teacherLevel);

}
