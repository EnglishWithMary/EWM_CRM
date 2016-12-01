package evg.testt.dao;

import evg.testt.model.Group;
import evg.testt.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupDao extends JpaRepository<Group, Integer> {

    List<Group> findByTeacher(Teacher teacher);

    List<Group> findByGroup (Group group);
}
