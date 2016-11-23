package evg.testt.service.impl;

import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import evg.testt.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends BaseService<Student, StudentRepository> implements StudentService {

    @Override
    public List<Student> getAllByTeacher(int teacher_id) {
        return dao.findStudensByTeacher(teacher_id);
    }

    @Override
    public List<Student> getStudentsWithoutTeacher() {
        return dao.findStudentsWithoutTeacher();
    }
}