package evg.testt.service.impl;

import evg.testt.model.Student;
import evg.testt.dao.StudentDao;
import evg.testt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl extends BaseService<Student, StudentDao> implements StudentService {

    @Override
    public List<Student> getAllByTeacher(int teacher_id) {
        return dao.findStudensByTeacher(teacher_id);
    }

    @Override
    public List<Student> getStudentsWithoutTeacher() {
        return dao.findStudentsWithoutTeacher();
    }
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getSortedByRegistrationDate() throws SQLException {
        return studentDao.findSortedByRegistrationDate();
    }
}