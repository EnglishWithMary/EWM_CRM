package evg.testt.service.impl;

import evg.testt.dao.StudentDao;
import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import evg.testt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl extends BaseService<Student, StudentRepository> implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getSortedByRegistrationDate() throws SQLException {
        return studentRepository.findSortedByRegistrationDate();
    }
}