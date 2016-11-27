package evg.testt.dao;

import evg.testt.model.Group;
import evg.testt.model.Teacher;

import java.util.List;

public interface GroupDao extends BaseDao<Group> {

    List<Group> findByTeacher(Teacher teacher);
}
