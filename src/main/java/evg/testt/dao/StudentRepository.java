package evg.testt.dao;

import evg.testt.model.Student;
import org.springframework.data.domain.Sort;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository extends RegisteredUserRepository<Student>{
    List<Student> findStudensByTeacher(int teacher_id);
    List<Student> findStudentsWithoutTeacher();
    List<Student> findStudentsByGroup(int group_id);
    List<Student> findStudentsWithoutGroup();
    List<Student> findStudentsWithGroup()throws SQLException;
    Student findStudentByPersonId(Integer personId);

    List<Student> findStudentsPageWithFilters(int pageNumber, Integer teacher_id,
                                              List<Integer> groupIdList, String direction
    ) throws SQLException;
    int countByFilter(Integer teacher_id, List<Integer> groupIdList) throws SQLException;
}
