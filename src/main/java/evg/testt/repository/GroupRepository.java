package evg.testt.repository;

import evg.testt.model.Group;
import evg.testt.model.Student;
import evg.testt.model.Teacher;

import java.util.List;

public interface GroupRepository extends BaseRepository<Group>{

    List<Group> findByTeacher(Teacher teacher);

    List<Group> findByGroup (Group group);
}
