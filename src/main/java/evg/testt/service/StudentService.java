package evg.testt.service;

import evg.testt.model.Student;
import org.springframework.data.domain.Sort;

import java.util.Collection;
import java.util.List;

import java.sql.SQLException;
import java.util.List;

public interface StudentService extends RegisteredUserService<Student> {
    List<Student> getAllByTeacher(int teacher_id);
    List<Student> getStudentsWithoutTeacher();
    List<Student> getAllByGroup(int group_id);
    List<Student> getStudentsWithoutGroup();
    List<Student> getAllStudentsWithGroup() throws SQLException;

    List<Student> getStudentsPageWithFilters(int pageNumber, Integer teacher_id,
                                              List<Integer> groupIdList, String direction
    ) throws SQLException;

    int countByFilter(Integer teacher_id, List<Integer> groupIdList) throws SQLException;

    Student getStudentByPersonId(Integer personId);
}
