package evg.testt.service;

import evg.testt.model.Student;
import evg.testt.model.StudentLevelHistory;

import java.util.List;

public interface StudentLevelHistoryService extends Service<StudentLevelHistory> {
    public List<StudentLevelHistory> getAllByStudentId(Integer id);

    public StudentLevelHistory getLastByStudent(Student student);
}
