package evg.testt.service.impl;

import evg.testt.model.RegisteredUser;
import evg.testt.model.Student;
import evg.testt.dao.StudentRepository;
import evg.testt.service.HumanService;
import evg.testt.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl extends RegisteredUserServiceImpl<Student, StudentRepository> implements StudentService {

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
    public List<Student> getStudentsWithoutGroup() {
        return dao.findStudentsWithoutGroup();
    }

    @Override
    public List<Student> getAllStudentsWithGroup() throws SQLException {return dao.findStudentsWithGroup();
    }
}