package evg.testt.service.impl;

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

    @Override
    public List<Student> getAllByTeacher(int teacher_id) {
        return dao.findStudensByTeacher(teacher_id);
    }

    @Override
    public List<Student> getStudentsWithoutTeacher() {
        return dao.findStudentsWithoutTeacher();
    }

    @Override
    public List<Student> getAllByGroup(int group_id) {
        return dao.findStudentsByGroup(group_id);
    }

    @Override
    public List<Student> getStudentWithoutGroup() {
        return dao.findStudentWithoutGroup();
    }
}