package evg.testt.dao;

import evg.testt.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
