package evg.testt.dao;

import evg.testt.model.Teacher;
import evg.testt.model.TeacherLevelEnum;

import java.util.List;

public interface TeacherRepository extends StaffRepository<Teacher> {

    Teacher findTeacherByPersonId(Integer personId);

    List<Teacher> findTeacherByLevel(TeacherLevelEnum teacherLevel);

}
