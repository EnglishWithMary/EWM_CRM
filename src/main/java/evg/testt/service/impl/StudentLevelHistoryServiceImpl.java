package evg.testt.service.impl;

import evg.testt.dao.StudentLevelHistoryRepository;
import evg.testt.model.Student;
import evg.testt.model.StudentLevelHistory;
import evg.testt.service.StudentLevelHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentLevelHistoryServiceImpl extends BaseService<StudentLevelHistory, StudentLevelHistoryRepository> implements StudentLevelHistoryService {
    @Override
    public List<StudentLevelHistory> getAllByStudentId(Integer id) {
        return dao.getByStudentId(id);
    }

    @Override
    public StudentLevelHistory getLastByStudent(Student student) {
        return dao.getLastByStudent(student);
    }
}
